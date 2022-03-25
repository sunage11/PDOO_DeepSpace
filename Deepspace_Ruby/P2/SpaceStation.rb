# BOLÍVAR PELÁEZ, CLARA
# RUIZ GÓMEZ, SOLEDAD
# 2º DGIIM - PDOO - Practice 2 DeepSpace

# SpaceStation
# 

module DeepSpace

    class SpaceStation

        attr_reader :ammoPower, :hangar, :name, :nMedals, :pendingDamage, :shieldBoosters, :shieldPower, :speed, :weapons

        @@MAXFUEL = 100
        @@SHIELDLOSSPERUNITSHOT = 0.1
        
        # Constructores HACER
        def initialize (n, s)
            @ammoPower = s.ammoPower
            @fuelUnits = s.fuelUnits
            @shieldPower = s.shieldPower
            @name = n 
            @nMedals = 0
            @pendingDamage = nil
            @hangar = nil
            @weapons = Array.new
            @shieldBoosters = Array.new 

        end

        # otro
        # otro

        #otro

        def assignFuelValue (f)
            
        end

        def cleanPendingDamage ()
        end

        def cleanUpMountedItems ()
        end

        def discardHangar ()
        end

        def discardShieldBooster (i)
        end

        def discardShieldBoosterInHangar (i)
        end

        def discardWeapon (i)
        end

        def discardWeaponInHangar (i)
        end

        def fire
        end

        # builds a new WeaponToUI object from self
        def UIVersion
            SpaceStationToUI.new(self)
        end

        def mountShieldBooster (i)
        end

        #It trys to mount the weapon with the index i inside the hangar. If 
        #a hangar is available, it removes the weapon located in that position 
        #and if this opera
        def mountWeapon (i)
            if(hangar != nil)
                aux = @hangar.removeWeapon(i)
                if(aux != nil)
                    @weapons.add(aux) 
                end
            end

            
        end

        #Decrease in fuel units due to a displacement. The number of stored 
        #units is subtracted a fraction that is equal to the speed of the station
        #fuelUnits cannot be a negative 
        def move
            @fuelUnits -= speed
        end

        #Builds a new WeaponToUI object from *this
        def protection
            #Se hace en la práctica 3
        end

        #If *this has not hangar, param h is the new hangar. If *this already 
        #has hangar, this method does not operate
        def receiveHangar (h)
            if(@hangar == nil)
                @hangar = Hangar.new(h)
        end

        #If *this has not hangar, returns false. Otherwise, it returns the 
        #result of trying to add the shield booster s to the hangar
        def receiveShieldBooster (s)
            if(@hangar == nil)
                return false
            else
                @hangar.addShieldBooster(s)
            end
        end

        
        def receiveShot (shot)
            #Se hace en la práctica 3
        end
        
        #Increments ammoPower, shieldPower and fuelUnits 
        def receiveSupplies (s)
            @ammoPower += s.ammoPower
            @fuelUnits+= s.fuelUnits
            @shieldPower+=s.shieldPower
        end

        #If *this has not hangar, returns false. Otherwise, it returns the 
        #result of trying to add the weapon w to the hangar
        def receiveWeapon (w)
            if(@hangar == nil)
                return false
            else
                return @hangar.addWeapon(w)
            end
        end

        def setLoot (loot)
            #Se hace en la práctica 3
        end

        #Calculates the adjusted damage from param d to the weapon and shield
        # collections in *this and then saves it in pendingDamage
        def setPendingDamage (d)
            @pendingDamage = d.adjuste(@weapons, @shieldBoosters)
        end

        #returns true if *this is in a valid state (this implies not to have
        #any pendingDamage at all or with any effect
        def validState
            return ((@pendingDamage == nil ) || (@pendingDamage.hasNoEffect))
        end


    end
end


        

