# BOLÍVAR PELÁEZ, CLARA
# RUIZ GÓMEZ, SOLEDAD
# 2º DGIIM - PDOO - Practice 1 DeepSpace

# EnemyStarShip
# It represents 

module DeepSpace

    class EnemyStarShip
       
        attr_reader :name, :ammoPower, :shieldPower, :loot, :damage

        #Constructor 
        def initialize(n,a,s,l,d)
            @name=n;
            @ammoPower=a;
            @shieldPower=s;
            @loot=l;
            @damage =  Damage.new(d);
            @gameUniverse =  GameUniverse.new();
        end

        #Copy constructor 
        def self.newCopy(e)
            @name=e.name;
            @ammoPower=e.ammoPower;
            @shieldPower= e.shieldPower;
            @loot = e.loot;
            @damage = Damage.new(e.damage);
        end

        #It builds a new HangarToUI object from *this
        def getUIversion
            return EnemyStarShipToUI.new(self)
        end

        # returns the shoot energy level of the enemy ship
        def fire
        end

        # returns the shield energy level of the enemy ship
        def protection
        end

        # returns the result of a received shot with a specific power
        # param shot power of the shot
        # return the result of the shot

        def receiveShot (shot)
            if (shot > @shieldPower)
                return ShotResult::DONOTRESIST
            else
                retunt ShotResult::RESIST 
            end 
        end

        
    end
end