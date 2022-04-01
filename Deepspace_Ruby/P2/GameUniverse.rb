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

        def combat (station, enemy)
        end

        def combat
        end

        def discardHangar
        end

        def discardShieldBooster (i)
        end

        def discardShieldBoosterInHangar (i)
        end

        def discardWeapon (i)
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

        def mountShieldBooster (i)
            if (@gameState.state == GameState::AFTERCOMBAT || 
                @gameState.state == GameState::INIT)
                currentStation.mountShieldBooster(i)
            end
        end

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
