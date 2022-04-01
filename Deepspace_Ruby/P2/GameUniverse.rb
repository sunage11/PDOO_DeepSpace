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
        end
        
        #Se hace en la práctica 3
        def combat (station, enemy)
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
        end

        # builds a new GameUniverseToUI object from self
        def getUIVersion
            GameUniverseToUI.new(self)
        end

        def haveAWinner
        end

        def ini (names)
        end

        def mountShieldBooster (i)
        end

        def mountWeapon (i)
        end

        def nextTurn 
        end

    end
end
