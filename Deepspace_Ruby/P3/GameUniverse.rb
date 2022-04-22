# BOLÍVAR PELÁEZ, CLARA
# RUIZ GÓMEZ, SOLEDAD
# 2º DGIIM - PDOO - Practice 3 DeepSpace

# GameUniverse
# 

require_relative 'GameStateController'

module Deepspace

    class GameUniverse

        attr_reader :gameState 

        @@WIN=10
        
        #Constructor
        public
        def initialize 
            @gameState= GameStateController.new
            @turns = 0
            @dice = Dice.new
            @currentStation = nil
            @currentStationIndex = -1
            @spaceStations = Array.new
            @currentEnemy = nil
        end
        
        #Se hace en la práctica 3
        def combatGo (station, enemy) #Dos métodos en Ruby no pueden tener el mismo nombre 
        end

        #Se hace en la práctica 3
        def combat
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
        def getUIVersion
            GameUniverseToUI.new(self)
        end

        #It returns true if the current space station has the number of 
        #medals needed to win.
        def haveAWinner
            if (currentStation.nMedals == WIN)
                return true
            else
                return false
            end
        end

        def init (names)
            if (@gameState.state == GameState::CANNOTPLAY)
                
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
                @currentStation = @spaceStation.at(@currentStationIndex)

                @currentEnemy = dealer.nextEnemy
                @gameState.next(turns, size)
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

        def nextTurn 
            if (@gameState.state == GameState::AFTERCOMBAT)
                if (@currentStation.validState)
                    size = @spaceStations.length

                    @currentStationIndex = (@currentStationIndex+1)%size
                    @turns += 1

                    @currentStation = @spaceStation.at(@currentStationIndex)
                    @currentStation.cleanUpMountedItems

                    dealer = CardDealer.instance

                    @currentEnemy = dealer.nextEnemy

                    @gameState.next(@turns, @size)

                    return true
                end

                return false

            end

            return false

        end

    end
end
