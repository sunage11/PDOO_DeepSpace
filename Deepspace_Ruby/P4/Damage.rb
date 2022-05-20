# BOLÍVAR PELÁEZ, CLARA
# RUIZ GÓMEZ, SOLEDAD
# 2º DGIIM - PDOO - Practice 3 DeepSpace

# Damage
# It represents the damage that an enemy starship makes to a
# spacial station when it loses a combat

require_relative 'DamageToUI'

module Deepspace

    class Damage
        
        #Constructor
        def initialize(s)
            @nShields = s
        end


        # returns a an adjusted version of *this. It takes into consideration
        # the parameters w ans sb in order to modify the output value so it does not
        # imply losing weapons or shields that are nos specified in w or sb
        public

        attr_reader :nShields

        def adjust (s)
            return [s.length, @nShields].min 
        end

        # it decrements nShields in one unit
        def discardShieldBooster
            if (@nShields>0)
                @nShields -= 1
            end
        end

        # returns true if *this does not imply any accessory loss
        def hasNoEffect
            return (@nShields==0)
        end

    end

end


        

