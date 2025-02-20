# BOLÍVAR PELÁEZ, CLARA
# RUIZ GÓMEZ, SOLEDAD
# 2º DGIIM - PDOO - Practice 3 DeepSpace

# Weapon
# It represents a spacial station's weapon


require_relative 'WeaponToUI'

module Deepspace

    class Weapon 

        # Constructor
        def initialize (n, t, u)
            @name   = n 
            @type   = t
            @uses   = u
        end

        # Copy constructor
        def self.newCopy (sw)
            return sw.clone
        end

        # Getters
        def type
            @type
        end

        def uses
            @uses
        end
        
        # Returns the weapon power
        def power
            @type.power()
        end


        # Decreases uses in one unit, returns boost if uses > 0
        # or 1.0 otherwise
        # Returns boost value or 1.0
        def useIt
            if (uses > 0)
                @uses -=1
                power
            else
                1.0
            end 
        end

        #toString
        def to_s
            return getUIversion().to_s
        end
        
         #To UI
         def getUIversion
            return WeaponToUI.new(self)
        end

    end

end
