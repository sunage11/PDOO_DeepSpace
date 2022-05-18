# BOLÍVAR PELÁEZ, CLARA
# RUIZ GÓMEZ, SOLEDAD
# 2º DGIIM - PDOO - Practice 4 DeepSpace

# NumericDamage
# It represents numeric damage

require_relative 'Damage'
require_relative 'NumericDamageToUI'

module Deepspace
      
    class NumericDamage < Damage 

        attr_reader :nWeapons

        # Constructor
        def initialize (w,s)
            super(s)
            @nWeapons = w
        end

        #copy
        def copy
            return self.clone
        end

        #adjust
        def adjust (w, s)
            shields = super(s)
            output = NumericDamage.new([@nWeapons, w.length].min, shields)
            return output
        end

        # If *this has w.getType() in the array weapons, it deletes that element
        # of the array. In other case, it decrements nWeapons in one unit
        def discardWeapon (w)
            if (@nWeapons>0)
                @nWeapons -= 1
            end
        end 

        # returns true if *this does not imply any accessory loss
        def hasNoEffect
            return ((@nWeapons==0) && super)
        end

        # Getter
        def power
            @power
        end

        #toString
        def to_s
            return getUIversion().to_s
        end

        #getUIversion
        def getUIversion
            return NumericDamageToUI.new(self)
        end
            
    end

end