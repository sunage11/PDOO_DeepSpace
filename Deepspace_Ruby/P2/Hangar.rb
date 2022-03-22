# BOLÍVAR PELÁEZ, CLARA
# RUIZ GÓMEZ, SOLEDAD
# 2º DGIIM - PDOO - Practice 1 DeepSpace

# Hangar
# It represents 

require_relative 'HangarToUI'
require_relative 'Weapon'
require_relative 'ShieldBooster'
require_relative 'WeaponType'

module DeepSpace
    class Hangar

        #Constructor
        def initialize(capacity)
            @maxElements=capacity
            @shieldBoosters = Array.new
            @weapons= Array.new
        end

        #Copy constructor 
        def self.newCopy(h)
            copy = new(h.maxElements)

            h.shieldBoosters.each do |s|
                copy.addShieldBooster(s)
            end

            h.weapons.each do |w|
                copy.addWeapon(w)
            end

            return copy
        end

        #It builds a new HangarToUI object from *this
        def getUIversion
            return HangarToUI.new(self)
        end
        
        # It returns true if elements can be added. 
        # return true if there is empty space to add elements, false in other case

        def spaceAvailable
            currentElements=@shieldBoosters.size() + @weapons.size()
            return(maxElements > currentElements)
        end


        # Adds w to the weapons array if there is enough room for it
        # param w weapon to add
        # return true if it has been added or false otherwise
    
        def addWeapon(w)
            if(spaceAvailable())
                @weapons.add(w)
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
                @shieldBoosters.add(w)
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
            if (@shieldBoosters.size > s) {
                Weapon output = @shieldBoosters.at(s);
                @shieldBoosters.delete_at(s);
                return output;
            else
                return nil;
            end
        end

        # Deletes the weapon number w (if possible) and returns it. In other 
        # case, it returns null.
        # param w The index of the weapon to delete
        # returns The deleted weapon
        def removeWeapon (w)
            if (@weapons.size > w) {
                Weapon output = @weapons.at(w);
                @weapons.delete_at(w);
                return output;
            else
                return nil;
            end
        end
     


    end 
end
