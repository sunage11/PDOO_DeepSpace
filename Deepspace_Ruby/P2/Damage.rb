# BOLÍVAR PELÁEZ, CLARA
# RUIZ GÓMEZ, SOLEDAD
# 2º DGIIM - PDOO - Practice 2 DeepSpace

# Damage
# It represents the damage that an enemy starship makes to a
# spacial station when it loses a combat

module DeepSpace

    class Damage

        attr_reader :nShields, :nWeapons, :weapons
        
        # Constructor
        def initialize (w, s)
            @nShields = s 
            @nWeapons = w
            @weapons=Array.new()
        end

        # otro
        # otro

        #otro

        def getUIversion (d)
            DamageToUI.new(self)
        end

        def arrayContainsType (w, t)
        end

        def adjuste (w, s)
        end

        def discardWeapon (w)
        end

        def discardShieldBooster
        end

        def hasNoEffect
        end

    end
end


        

