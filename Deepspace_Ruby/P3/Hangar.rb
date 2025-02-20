# BOLÍVAR PELÁEZ, CLARA
# RUIZ GÓMEZ, SOLEDAD
# 2º DGIIM - PDOO - Practice 3 DeepSpace

# Hangar
# It represents 

require_relative 'HangarToUI'
require_relative 'Weapon'
require_relative 'ShieldBooster'
require_relative 'WeaponType'

module Deepspace
    class Hangar

        #Constructor
        def initialize(capacity)
            @maxElements=capacity
            @shieldBoosters = Array.new
            @weapons= Array.new
        end

        #Copy constructor 
        def self.newCopy(h)
            return h.clone
        end

        attr_reader :maxElements, :shieldBoosters, :weapons

        #It builds a new HangarToUI object from *this
        def getUIversion
            return HangarToUI.new(self)
          end
        
        # It returns true if elements can be added. 
        # return true if there is empty space to add elements, false in other case
        private 
        def spaceAvailable
            currentElements=@shieldBoosters.size() + @weapons.size()
            #puts maxElements.inspect
            if (@maxElements < currentElements)
                return true
            else
                return false
            end
        end


        # Adds w to the weapons array if there is enough room for it
        # param w weapon to add
        # return true if it has been added or false otherwise
        public 
        def addWeapon(w)
            if(spaceAvailable())
                @weapons.push(w)
                return true
            else 
                return false
            end
        end

        # Adds s to the shieldBoosters array if there is enough room for it
        # param s shield booster to add
        # return true if it has been added or false otherwise
        def addShieldBooster(s)
            if(spaceAvailable())
                @shieldBoosters.push(s)
                return true
            else 
                return false
            end
        end


        # Deletes the shield booster number s (if possible) and returns it. 
        # In other case, it returns null.
        # param s The index of the shield booster to delete
        # returns The deleted shield booster
        def removeShieldBooster (s)
            if (s>=0 && @shieldBoosters.length > s) 
                
                return @shieldBoosters.delete_at(s);
            else
                return nil;
            end
        end

        # Deletes the weapon number w (if possible) and returns it. In other 
        # case, it returns null.
        # param w The index of the weapon to delete
        # returns The deleted weapon
        def removeWeapon (w)
            if (w>=0 && @weapons.size > w) 
                return @weapons.delete_at(w);
            else
                return nil;
            end
        end


        #toString
        def to_s
            output = "Hangar [ maxElements #{@maxElements} ; " +
                     "shieldBoosters #{@shieldBoosters.to_s} ; " +
                     "weapons  #{@weapons.to_s} ]"
        end
     


    end 
end
