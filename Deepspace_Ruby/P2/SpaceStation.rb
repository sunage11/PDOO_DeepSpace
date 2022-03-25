# BOLÍVAR PELÁEZ, CLARA
# RUIZ GÓMEZ, SOLEDAD
# 2º DGIIM - PDOO - Practice 2 DeepSpace

# SpaceStation
# 

module DeepSpace

    class SpaceStation

        attr_reader :ammoPower, :fuelUnits, :hangar, :name, :nMedals, :pendingDamage, :shieldBoosters, :shieldPower, :weapons

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

        # Set the amount of fuel to the value passed without ever 
        # exceeding the limit.
        def assignFuelValue (f)
            if (f<=@@MAXFUEL)
                @fuelUnits = f
            else
                @fuelUnits = @@MAXFUEL
            end
        end

        # Set pending damage to null if it has no effect.
        def cleanPendingDamage ()
            if (pendingDamage.hasNoEffect)
                pendingDamage = nil
        end

        # It eliminates all mounted weapons and boosters that do not have 
        # any use left.
        def cleanUpMountedItems ()       
           
            @weapons.each do |aux|
                if(aux.uses == 0)
                    @weapons.delete(aux)
                end
            end

            @shieldBoosters.each do |aux|
                if(aux.uses == 0)
                    @shieldBoosters.delete(aux)
                end
            end
  
        end

        # Set the reference of the hangar to null to indicate that it 
        # is not available
        def discardHangar ()
            @hangar = nil
        end

        def discardShieldBooster (i)
            # next session
        end

        # If a hangar is available, it is requested to discard the booster 
        # with index i
        def discardShieldBoosterInHangar (i)
            if (@hangar != nil)
                @hangar.removeShieldBooster(i)
            end
        end

        # ---
        def discardWeapon (i)
            # next session
        end

        # If a hangar is available, it is requested to discard the weapon 
        # with index i.
        def discardWeaponInHangar (i)
            if (@hangar != nil)
                @hangar.removeWeapon(i)
            end
        end

        # --
        def fire
            # next session
        end

        # calculates the speed of the station
         def speed
            @fuelUnits/@@MAXFUEL
        end

        # builds a new WeaponToUI object from self
        def getUIVersion
            SpaceStationToUI.new(self)
        end

        # It tries to mount the booster with the index i inside the hangar. If 
        # a hangar is available, it removes the booster located in that position 
        # and if this operation is successful, it is added to the collection of
        # boosters in use.
        def mountShieldBooster (i)
            if (@hangar != nil)
                aux = @hangar.receiveShieldBooster(i)
                if (aux != nil)
                    @shieldBoosters.add(aux)
                end 
            end
        end

        def mountWeapon (i)
        end

        def move
        end

        def protection
        end

        def receiveHangar (h)
        end

        def receiveShieldBooster (s)
        end

        def receiveShot (shot)
        end

        def receiveSupplies (s)
        end

        def receiveWeapon (w)
        end

        def setLoot (loot)
        end

        def setPendingDamage (d)
        end

        def validState
        end


    end
end


        

