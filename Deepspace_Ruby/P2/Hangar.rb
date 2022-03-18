# BOLÍVAR PELÁEZ, CLARA
# RUIZ GÓMEZ, SOLEDAD
# 2º DGIIM - PDOO - Practice 1 DeepSpace

# Hangar
# It represents 

require_relative 'HangarToUI'
require_relative 'Weapon'
require_relative 'ShieldBooster'
require_relative 'WeaponType'

module DeepSpace
    class Hangar

        #Constructor
        def initialize
        end

        #Copy constructor 
        def self.newCopy(h)
        end

        #It builds a new HangarToUI object from *this
        def getUIversion
            return HangarToUI.new(self)
        end
        
        #
        def spaceAvailable
        
        end

        #
        def addWeapon(w)
        end

        #
        def addShieldBooster(s)
        end

        #Get maxElements value
        def getMaxElements
            @maxElements
        end

        #
        def getShieldBoosters
        end

        #Get weapons objects
        def getWeapons
        end

        #
        def removeShieldBooster(s)
        end

        #
        def removeWeapon(w)
        end
     


    end 
end
