# BOLÍVAR PELÁEZ, CLARA
# RUIZ GÓMEZ, SOLEDAD
# 2º DGIIM - PDOO - Practice 3 DeepSpace

# Weapon
# It represents a spacial station's shield booster

require_relative'ShieldToUI'

module Deepspace

    class ShieldBooster 

        # Constructor
        def initialize (n, b, u)
            @name   = n 
            @boost  = b
            @uses   = u
        end

        # Copy constructor
        def self.newCopy (s)
            new(s.name, s.boost, s.uses)
        end

        # Getters
        def boost
            @boost
        end

        def uses
            @uses
        end

        # Decreases uses in one unit, returns boost if uses > 0
        # or 1.0 otherwise
        # Returns boost value or 1.0
        def useIt
            if (uses > 0)
                @uses -=1
                @boost
            else
                1.0
            end 
        end

        # builds a new ShieldToUI object from self
        def getUIversion
            ShieldToUI.new(self)
        end

         #toString
         def to_s
            output = "ShieldBooster [ name #{@name} ; " +
                     "boost #{@boost} ; " +
                     "uses  #{@uses} ]"
        end
        

    end

end