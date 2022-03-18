# BOLÍVAR PELÁEZ, CLARA
# RUIZ GÓMEZ, SOLEDAD
# 2º DGIIM - PDOO - Practice 1 DeepSpace

# SuppliesPackage
# It represents a spacial station's supplies

module DeepSpace

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

    end

end