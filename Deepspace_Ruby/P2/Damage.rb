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
        def newNumericWeapons (w, s)
            @nShields = s 
            @nWeapons = w
            @weapons=Array.new()
        end

        #Constructor 
        def newSpecificWeapons(w,s)
            @weapons=Array.new(w)
            @nShields= s
            @nWeapons= @weapons.size
            
        end
        # otro

        #otro

        def getUIversion (d)
            DamageToUI.new(self)
        end

        def arrayContainsType (w, t)
            cont=true
            i=0

            while (i<@nWeapons && cont)
                if(t == w.get(i).getType)
                    cont=false
                end
            end

            if(cont == false)
                return if
            else
                return -1
            end

        end

        def adjuste (w, s)
        end

        def discardWeapon (w)
        end

        def discardShieldBooster
        end

        def hasNoEffect
        end

        #toString
        def to_s
            output = "Damage [ nShields #{@nShields} ; " +
                     "nWeapons #{@nWeapons} ; " +
                     "weapons  #{@weapons.to_s} ]"
        end

    end
end


        

