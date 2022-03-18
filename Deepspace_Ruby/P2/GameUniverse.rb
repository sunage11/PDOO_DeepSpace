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
