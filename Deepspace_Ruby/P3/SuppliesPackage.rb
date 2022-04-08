# BOLÍVAR PELÁEZ, CLARA
# RUIZ GÓMEZ, SOLEDAD
# 2º DGIIM - PDOO - Practice 3 DeepSpace

# SuppliesPackage
# It represents a spacial station's supplies

module Deepspace

    class SuppliesPackage 

        # Constructor
        def initialize (a, f, s)
            @ammoPower      = a
            @fuelUnits      = f 
            @shieldPower    = s
        end

        # Copy constructor
        def self.newCopy (s)
            new(s.ammoPower, s.fuelUnits, s.shieldPower)
        end

        # Getters
        def ammoPower
            @ammoPower
        end

        def fuelUnits
            @fuelUnits
        end

        def shieldPower
            @shieldPower
        end

        #toString
        def to_s
            output = "SuppliesPackage [ ammoPower #{@ammoPower} ;fuelUnits "+
                   "#{@fuelUnits}  ;shieldPower  #{@shieldPower} ]"
        end 

    end

end