# BOLÍVAR PELÁEZ, CLARA
# RUIZ GÓMEZ, SOLEDAD
# 2º DGIIM - PDOO - Practice 2 DeepSpace

# GameUniverse
# 

module DeepSpace

    class GameUniverse

        #ctores blabla

        attr_reader :state 

        @@WIN=10
        
        #Constructor
        def initialize 
            @gameState= GameStateController.new()
            @turns = 0
            @dice = Dice.new()
            @currentStation = nil
            @spaceStations = Array.new
            @currentEnemy = nil
            @gameState = GameStateController.new

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
            if(@gamestate.state == GameState::AFTERCOMBAT ||
                @gameState.state == GameState::INIT)
                @currentStation.discardHangar
        end

        #discards shield booster i of the current station if gameState is 
        #INIT or AFTERCOMBAT
        def discardShieldBooster (i)
            if(@gamestate.state == GameState::AFTERCOMBAT ||
                @gameState.state == GameState::INIT)
                @currentStation.discardShieldBooster(i)
        end

        #discards shield booster i of the current station's hangar if 
        #gameState is INIT or AFTERCOMBAT
        def discardShieldBoosterInHangar (i)
            if(@gamestate.state == GameState::AFTERCOMBAT ||
                @gameState.state == GameState::INIT)
                @currentStation.discardShieldBoosterInHangar(i)
        end

        #discards weapon i of the current station if gameState is INIT 
        #or AFTERCOMBAT
        def discardWeapon (i)
            if(@gamestate.state == GameState::AFTERCOMBAT ||
                @gameState.state == GameState::INIT)
                @currentStation.discardWeapon(i)
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
