# BOLÍVAR PELÁEZ, CLARA
# RUIZ GÓMEZ, SOLEDAD
# 2º DGIIM - PDOO - Practice 1 DeepSpace

# Weapon
# It represents a spacial station's weapon

<<<<<<< HEAD
require_relative'WeaponToUI'
=======

require_relative 'WeaponToUI'
>>>>>>> b56c07a8099700aa36fee02faffb2aadc4b580b0

module DeepSpace

    class Weapon 

        # Constructor
        def initialize (n, t, u)
            @name   = n 
            @type   = t
            @uses   = u
        end

        # Copy constructor
        def self.newCopy (sw)
            new(w.name, w.type, w.uses)
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
       
        # builds a new DamageToUI object from *this
        def getUIversion 
            WeaponToUI.new(self)
        end

        #toString
        def to_s
            output = "Weapon [ name #{@name} ; " +
                     "type #{@type} ; " +
                     "uses  #{@uses} ]"
        end
        
         #To UI
         def getUIversion
            return WeaponToUI.new(self)
        end

    end

end
