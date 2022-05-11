# BOLÍVAR PELÁEZ, CLARA
# RUIZ GÓMEZ, SOLEDAD
# 2º DGIIM - PDOO - Practice 4 DeepSpace

# SpecificDamage

module Deepspace
    class SpecificDamage < Damage 
        
        attr_reader :weapons

            #Constructor
        def initialize(s,ws)
            super(s)
            if !ws.nil?
                 @weapons = ws.clone
            else
                @weapons = []
            end

        end

        # Getter
        def copy
            return self.clone
        end

        private
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

        public
        def adjust (w, s)
            shields = super(s)

                aux = []
                aux2 = w.clone

                weapons.each do |element|
                    i = arrayContainsType(aux2, element)
                    if i != -1
                        aux2.delete_at(i)
                        aux.push(element)
                    end
                end
                output = SpecificDamage.new(aux, shields)
                return output
            end
        end

        # If *this has w.getType() in the array weapons, it deletes that element
        # of the array. In other case, it decrements nWeapons in one unit
        def discardWeapon (w)
            if (!@weapons.empty?)
                pos= @weapons.index(w.type)
                if (pos!=nil)
                    @weapons.delete_at(pos) 
                
            end
        end

        # returns true if *this does not imply any accessory loss
        def hasNoEffect
            return ( super && (@weapons.empty?))
        end

        #toString
        def to_s
            output = "Damage [ nShields #{@nShields} ; " +
                     "weapons  #{@weapons.to_s} ]"
        end

        def getUIversion
            SpecificDamageToUI.new(self)
        end


    end
end