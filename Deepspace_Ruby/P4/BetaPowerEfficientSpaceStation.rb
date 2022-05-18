# BOLÍVAR PELÁEZ, CLARA
# RUIZ GÓMEZ, SOLEDAD
# 2º DGIIM - PDOO - Practice 4 DeepSpace

# BetaPowerEfficientSpaceStation
# 

module Deepspace

    class BetaPowerEfficientSpaceStation < PowerEfficientSpaceStation

        @@EXTRAEFFICIENCYFACTOR = 1.20
        
        # Constructores
        def initialize (s)
            super
            @dice = Dice.new
        end

        # fire
        def fire 
            if (dice.extraEfficiency)
                super*@@EXTRAEFFICIENCYFACTOR
            else
                super
            end
        end

        # ToUI
        # builds a new BetaPowerEfficientSpaceStation object from self
        def getUIversion
            BetaPowerEfficientSpaceStation.new(self)
        end

    end
end
