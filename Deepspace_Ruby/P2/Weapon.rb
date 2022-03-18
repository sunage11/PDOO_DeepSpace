# BOLÍVAR PELÁEZ, CLARA
# RUIZ GÓMEZ, SOLEDAD
# 2º DGIIM - PDOO - Practice 1 DeepSpace

# Weapon
# It represents a spacial station's weapon

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

        #toString
        def to_s
            output = "Weapon [ name #{@name} ; " +
                     "type #{@type} ; " +
                     "uses  #{@uses} ]"
        end
        
        

    end

end
