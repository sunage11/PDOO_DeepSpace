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
        def initialize (w, s)
            @nShields = s 
            @nWeapons = w
            @weapons=Array.new()
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
        
        def getAmmoPower
        end

        # builds a new WeaponToUI object from self
        def getUIVersion
            SpaceStationToUI.new(self)
        end

        def mountShieldBooster (i)
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


        

