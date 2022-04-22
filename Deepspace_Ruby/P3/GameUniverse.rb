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
        
        #A combat between the space station and the enemy that are received
        #as parameters takes place. The procedure described in the rules of the 
        # game is followed: draw for who shoots first, possibility of escape, 
        # allocation of loot, recording of pending damage, etc. 
        # The result of the combat is returned.
        
        def combatGo (station, enemy) #Dos métodos en Ruby no pueden tener el mismo nombre 
            ch=@dice.firstShot
            fire
            result
            enemyWins
            combatResult

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
                    damage = enemy.Damage
                    station.setPendingDamage(damage)
                    combatResult = CombatResult::ENEMYWINS
                else
                    station.move
                    combatResult = CombatResult::STATIONESCAPES
                end 

            else
                aLoot=enemy.loot
                station.setLoot(aLoot)
                combatResult = CombatResult::STATIONWINS
            end

            @gameState.next(@turns,@spaceStations.size)

            return combatResult


        end

        #Se hace en la práctica 3
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
            # P3
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
            #Siguiente practica
        end

    end
end
