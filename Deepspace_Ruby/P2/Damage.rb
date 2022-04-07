# BOLÍVAR PELÁEZ, CLARA
# RUIZ GÓMEZ, SOLEDAD
# 2º DGIIM - PDOO - Practice 2 DeepSpace

# Damage
# It represents the damage that an enemy starship makes to a
# spacial station when it loses a combat

module DeepSpace

    class Damage

        attr_reader :nShields, :nWeapons, :weapons
        
        # nWeapons constructor -> numeric damage
        def newNumericWeapons (w, s)
            @nShields = s 
            @nWeapons = w
            @weapons=Array.new()
            @weapons=nil
        end

        # WeaponType constructor -> specific damage 
        def newSpecificWeapons(w,s)
            @weapons=Array.new(w)
            @nShields= s
            @nWeapons= -1
            
        end

        # Copy constructor
        def newCopy(d)
            return d.clone
        end


        # builds a new DamageToUI object from *this
        def getUIversion (d)
            DamageToUI.new(self)
        end
        
        # ----
        def arrayContainsType (w, t)
            
            pos=0;

            w.each do |aux|
                if(aux.type == t)
                    return pos
                else
                    pos+=1
                end
            end

            return -1

        end

        # returns a an adjusted version of *this. It takes into consideration
        # the parameters w ans sb in order to modify the output value so it does not
        # imply losing weapons or shields that are nos specified in w or sb
        def adjust (w, s)
            shields = [@nShields, s.lenght].min 

            # If it is numeric damage
            if (@nWeapons != -1)
                output = Damage.new([@nWeapons, w.lenght].min, shields)
                return output
            else
                aux = []
                aux2 = w.clone

                weapons.each do |element|
                    i = arrayContainsType(aux2, element)
                    if (i != -1)
                        aux2.delete_at(i)
                        aux << element
                    end
                end
                output = Damage.new(aux, shields)
                return output
            end
        end


        # If *this has w.getType() in the array weapons, it deletes that element
        # of the array. In other case, it decrements nWeapons in one unit
        def discardWeapon (w)
            if (@weapons.delete(w) == nil)
                if (@nWeapons>0)
                    @nWeapons -= 1
                end
            end
        end

        # it decrements nShields in one unit
        def discardShieldBooster
            if (@nShields>0)
                @nShields -= 1
            end
        end

        # returns true if *this does not imply any accessory loss
        def hasNoEffect
            return ((@nWeapons==0) && (@nShields==0) && (@weapons.empty?))
        end

        #toString
        def to_s
            output = "Damage [ nShields #{@nShields} ; " +
                     "nWeapons #{@nWeapons} ; " +
                     "weapons  #{@weapons.to_s} ]"
        end

    end
end


        

