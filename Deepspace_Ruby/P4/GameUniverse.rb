# BOLÍVAR PELÁEZ, CLARA
# RUIZ GÓMEZ, SOLEDAD
# 2º DGIIM - PDOO - Practice 3 DeepSpace

# GameUniverse
# 

require_relative 'GameStateController'
require_relative 'Dice'
require_relative 'GameUniverseToUI'
require_relative 'SpaceStation'
require_relative 'EnemyStarShip'
require_relative 'GameStateController'
require_relative 'Loot'
require_relative 'CombatResult'
require_relative 'ShotResult'
require_relative 'CardDealer'

module Deepspace

    class GameUniverse

        attr_reader :gameState 

        @@WIN=10
        
        #Constructor
        public
        def initialize 
            @gameState= GameStateController.new
            @turns = 0
            @dice=Dice.new
            @currentStation = nil
            @currentStationIndex = -1
            @spaceStations = Array.new
            @currentEnemy = nil
            @haveSpaceCity = false
        end
        
        # A combat between the space station and the enemy that are received
        # as parameters takes place. The procedure described in the rules of the 
        # game is followed: draw for who shoots first, possibility of escape, 
        # allocation of loot, recording of pending damage, etc. 
        # The result of the combat is returned.
        
        def combatGo (station, enemy) #Dos métodos en Ruby no pueden tener el mismo nombre 
            ch=@dice.firstShot

            if(ch == GameCharacter::ENEMYSTARSHIP)
                fire = enemy.fire
                result = station.receiveShot(fire)
                if(result == ShotResult::RESIST)
                    fire = station.fire
                    result = enemy.receiveShot(fire)
                    enemyWins = (result==ShotResult::RESIT)
                else
                    enemyWins = true
                end
            else
                fire=station.fire
                result=enemy.receiveShot(fire)
                enemyWins=(result==ShotResult::RESIST)
            end

            if(enemyWins)
                s = station.speed
                moves = @dice.spaceStationMoves(s)

                if(moves)
                    damage = enemy.d amage
                    station.setPendingDamage(damage)
                    combatResult = CombatResult::ENEMYWINS
                else
                    station.move
                    combatResult = CombatResult::STATIONESCAPES
                end 

            else
                aLoot=enemy.loot
                transformation = station.setLoot(aLoot)

                if (transformation == Transformation::GETEFFICIENT)
                    makeStationEfficient
                    combatResult = CombatResult::STATIONWINSANDCONVERTS

                elsif (transformation == Transformation::SPACECITY)
                    createSpaceCity
                    combatResult = CombatResult::STATIONWINSANDCONVERTS
                
                else
                    combatResult = CombatResult::STATIONWINS

            end

            @gameState.next(@turns,@spaceStations.size)

            return combatResult

        end

        def state
            @gameState.state 
        end

        # method
        def combat

            state = @gameState.state

            if(state == GameState::BEFORECOMBAT || state == GameState::INIT)
                return combatGo(@currentStation, @currentEnemy)
            else
                return CombatResult::NOCOMBAT
            end

        end

        #discards hangar of the current station if gameState is INIT or 
        #AFTERCOMBAT
        def discardHangar
            if(@gameState.state == GameState::AFTERCOMBAT ||
                @gameState.state == GameState::INIT)
                @currentStation.discardHangar
            end
        end

        #discards shield booster i of the current station if gameState is 
        #INIT or AFTERCOMBAT
        def discardShieldBooster (i)
            if(@gameState.state == GameState::AFTERCOMBAT ||
                @gameState.state == GameState::INIT)
                @currentStation.discardShieldBooster(i)
            end
        end

        #discards shield booster i of the current station's hangar if 
        #gameState is INIT or AFTERCOMBAT
        def discardShieldBoosterInHangar (i)
            if(@gameState.state == GameState::AFTERCOMBAT ||
                @gameState.state == GameState::INIT)
                @currentStation.discardShieldBoosterInHangar(i)
            end
        end

        #discards weapon i of the current station if gameState is INIT 
        #or AFTERCOMBAT
        def discardWeapon (i)
            if(@gameState.state == GameState::AFTERCOMBAT ||
                @gameState.state == GameState::INIT)
                @currentStation.discardWeapon(i)
            end
        end

        def discardWeaponInHangar (i)
            if (@gameState.state == GameState::AFTERCOMBAT || 
                @gameState.state == GameState::INIT)
                currentStation.discardWeaponInHangar(i)
            end  
        end

        # builds a new GameUniverseToUI object from self
        def getUIversion
           return GameUniverseToUI.new(@currentStation, @currentEnemy)
        end

        #It returns true if the current space station has the number of 
        #medals needed to win.
        def haveAWinner
            if (@currentStation.nMedals == @@WIN)
                return true
            else
                return false
            end
        end

        def init (names)
            if (state == GameState::CANNOTPLAY)
                
                @spaceStations = Array.new
                dealer = CardDealer.instance

                size = names.length
                
                names.each do |name|
                    supplies = dealer.nextSuppliesPackage
                    station = SpaceStation.new(name, supplies)
                    @spaceStations << station

                    nh = @dice.initWithNHangars()
                    nw = @dice.initWithNWeapons()
                    ns = @dice.initWithNShields()

                    lo = Loot.new(0, nw, ns, nh, 0)
                    station.setLoot(lo)
                end

                @currentStationIndex = @dice.whoStarts(size)
                @currentStation = @spaceStations[@currentStationIndex]

                @currentEnemy = dealer.nextEnemy
                @gameState.next(@turns, @spaceStations.length)
            else
                puts "Unexpected gamestate at GameUniverse.init()"
                puts "The game state is #{state}"
                puts "Nothing is done!"
        
            end
        end

        #If the game state is INIT or AFTERCOMBAT, the  current space 
        #station calls its own method mountShieldBooster. Otherwise, it has no effect.
        def mountShieldBooster (i)
            if (@gameState.state == GameState::AFTERCOMBAT || 
                @gameState.state == GameState::INIT)
                currentStation.mountShieldBooster(i)
            end
        end

        #If the game state is INIT or AFTERCOMBAT, the  current space 
        # station calls its own method mountWeapon. Otherwise, it has no effect.
        def mountWeapon (i)
            if (@gameState.state == GameState::AFTERCOMBAT || 
                @gameState.state == GameState::INIT)
                currentStation.mountWeapon(i)
            end        
        end

        # method
        def nextTurn 
            if (@gameState.state == GameState::AFTERCOMBAT)
                if (@currentStation.validState)
                    size = @spaceStations.length

                    @currentStationIndex = (@currentStationIndex+1)%size
                    @turns += 1

                    @currentStation = @spaceStations.at(@currentStationIndex)
                    @currentStation.cleanUpMountedItems

                    dealer = CardDealer.instance

                    @currentEnemy = dealer.nextEnemy

                    @gameState.next(@turns, size)

                    return true
                end

                return false

            end

            return false

        end

        # method
        def createSpaceCity 
            if (!@haveSpaceCity)
                @haveSpaceCity = true
                collaborators = Array.new(@spaceStations)
                collaborators.delete(@currentStation)

                @currentStation = SpaceCity.new(@currentStation, collaborators)
                @spaceStations[@currentStationIndex] = @currentStation
            end
        end

        # method
        def makeStationEfficient
            if (@dice.extraEfficiency)
                @currentStation = BetaPowerEfficientStation.new(@currentStation)
            else
                @currentStation = PowerEfficientStation.new(@currentStation)
            end

            @spaceStations[@currentStationIndex] = @currentStation
        end

        # to_s
        def to_s
            return getUIversion().to_s
        end

    end
end
