# BOLÍVAR PELÁEZ, CLARA
# RUIZ GÓMEZ, SOLEDAD
# 2º DGIIM - PDOO - Practice 3 DeepSpace

# SpaceStation
# 

module Deepspace

    class SpaceStation

        attr_reader :fuelUnits, :ammoPower, :hangar, :name, :nMedals, :pendingDamage, :shieldBoosters, :shieldPower, :speed, :weapons

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

        # Set the amount of fuel to the value passed without ever 
        # exceeding the limit.
        private
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
        end

        # It eliminates all mounted weapons and boosters that do not have 
        # any use left.
        public
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

        # an attempt is made to discard the shield booster with index i from 
        # the current shield booster pool. In addition to losing the shield boost, 
        # it updates the pending damage if there is any
        def discardHangar ()
            @hangar = nil
        end

        def discardShieldBooster (i)
            size = @shieldBoosters.length

            if(i>=0 && i<size) 
                shieldBoosters.remove_at(i)

                if (pendingDamage != nil)
                    pendingDamage.discardShieldBooster
                    cleanPendingDamage
                end
            end
        end


        # If a hangar is available, it is requested to discard the booster 
        # with index i
        def discardShieldBoosterInHangar (i)
            if (@hangar != nil)
                @hangar.removeShieldBooster(i)
            end
        end

        # It tries to discard the weapon i of the array weapons. Apart from
        # losing the weapon, it should update the pendingDamage if there is any.
   
        def discardWeapon (i)
            size = @weapons.length

            if(i>=0 && i<size) 
                w = weapons.remove_at(i)

                if (pendingDamage != nil)
                    pendingDamage.discardWeapon(w)
                    cleanPendingDamage
                end
            end
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
            factor = 1

            weapons.each do |w|
                factor*=w.useIt
            end

            return ammoPower*factor

        end

        # calculates the speed of the station
         def speed
            @fuelUnits/@@MAXFUEL
        end

        # builds a new WeaponToUI object from self
        def getUIversion
            SpaceStationToUI.new(self)
        end

        # It tries to mount the booster with the index i inside the hangar. If 
        # a hangar is available, it removes the booster located in that position 
        # and if this operation is successful, it is added to the collection of
        # boosters in use.
        def mountShieldBooster (i)
            if (@hangar != nil)
                aux = @hangar.removeShieldBooster(i)
                if (aux != nil)
                    @shieldBoosters.add(aux)
                end 
            end
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
            factor = 1

            shieldBoosters.each do |s|
                factor*=s.useIt
            end

            return shieldPower*factor
        end

        #If *this has not hangar, param h is the new hangar. If *this already 
        #has hangar, this method does not operate
        def receiveHangar (h)
            if(@hangar == nil)
                @hangar = Hangar.newCopy(h)
            end
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
            
            myProtection=protection

            if(myProtection >= shot)
                @shieldPower-= @SHIELDLOSSPERUNITSHOT*shot 
                @shieldPower = [0.0, @shieldPower].max
                return ShotResult::RESIST 
            else
                @shieldPower=0.0
                return ShotResult::DONOTRESIST
            end
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
            dealer= CardDealer.instance # o Instance

            h=loot.nHangars

            if(h>0)
                hangar = dealer.nextHangar
                receiveHangar(hangar)
            end

            elements= loot.nSupplies
            elements.times do 
                sup = dealer.nextSuppliesPackage
                receiveSupplies(sup)
            end

            elements = loot.nWeapons
            elements.times do
                weap = dealer.nextWeapon
                receiveWeapon(weap)
            end

            elements = loot.nShields
            elements.times do
                sh = dealer.nextShieldBooster
                receiveShieldBooster(sh)
            end

            medals = loot.nMedals
            @nMedals+=medals

        end

        #Calculates the adjusted damage from param d to the weapon and shield
        # collections in *this and then saves it in pendingDamage
        def setPendingDamage (d)
            @pendingDamage = d.adjust(@weapons, @shieldBoosters)
        end

        #returns true if *this is in a valid state (this implies not to have
        #any pendingDamage at all or with any effect
        def validState
            return ((@pendingDamage == nil ) || (@pendingDamage.hasNoEffect))
        end


    end
end
