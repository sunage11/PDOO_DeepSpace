# BOLÍVAR PELÁEZ, CLARA
# RUIZ GÓMEZ, SOLEDAD
# 2º DGIIM - PDOO - Practice 4 DeepSpace

# PowerEfficientSpaceStation
# 

require_relative 'PowerEfficientSpaceStationToUI'

module Deepspace

    class PowerEfficientSpaceStation < SpaceStation

        attr_reader :collaborators

        @@EFFICIENCYFACTOR = 1.10
        
        # Constructores
        def initialize (s)
            newCopy(s)
        end

        # fire
        def fire 
            super*@@EFFICIENCYFACTOR
        end

        # protection
        def protection 
            super*@@EFFICIENCYFACTOR
        end

        # setLoot
        def setLoot (loot)
            transformation = super
            
            if (transformation == Transformation::SPACECITY)
                return Transformation::NOTRANSFORM
            else
                return transformation
            end
        end

        # ToUI
        # builds a new PowerEfficientSpaceStationToUI object from self
        def getUIversion
            PowerEfficientSpaceStationToUI.new(self)
        end

    end
end
