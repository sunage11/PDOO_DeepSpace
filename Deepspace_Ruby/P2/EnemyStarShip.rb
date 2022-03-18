# BOLÍVAR PELÁEZ, CLARA
# RUIZ GÓMEZ, SOLEDAD
# 2º DGIIM - PDOO - Practice 1 DeepSpace

# EnemyStarShip
# It represents 

def module
    class EnemyStarShip
       
        #Constructor 
        def initialize(n,a,s,l,d)
        end

        #Copy constructor 
        def self.newCopy(e)
        end

        #It builds a new HangarToUI object from *this
        def getUIversion
            return EnemyStarShipToUI.new(self)
        end

        #
        def fire
        end

        #Get AmmoPower value
        def getAmmoPower
            @ammoPower
        end

        #Get Damage value
        def getDamage
            @Damage
        end

        #Get Loot object
        def getLoot
            @Loot 
        end

        #Get name value
        def getName
            @name 
        end

        #Get ShieldPower value
        def getShieldPower
            @ShieldPower
        end

        #
        def protection
        end

        #
        def receive (shot)
        end

        
    end
end