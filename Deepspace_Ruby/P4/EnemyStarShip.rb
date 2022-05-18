# BOLÍVAR PELÁEZ, CLARA
# RUIZ GÓMEZ, SOLEDAD
# 2º DGIIM - PDOO - Practice 4 DeepSpace

# EnemyStarShip
# It represents 

require_relative 'Damage'
require_relative 'Loot'
require_relative 'EnemyToUI'
require_relative 'ShotResult'

module Deepspace

    class EnemyStarShip
       
        attr_reader :name, :ammoPower, :shieldPower, :loot, :damage

        #Constructor 
        def initialize(n,a,s,l,d)
            @name=n;
            @ammoPower=a;
            @shieldPower=s;
            @loot=l;
            @damage = damage;
        end

        #Copy constructor 
        def self.newCopy(e)
            return e.clone
        end

        #It builds a new HangarToUI object from *this
        def getUIversion
            return EnemyToUI.new(self)
        end

        # returns the shoot energy level of the enemy ship
        def fire
            return @ammoPower
        end

        # returns the shield energy level of the enemy ship
        def protection
            return @shieldPower
        end

        # returns the result of a received shot with a specific power
        # param shot power of the shot
        # return the result of the shot

        def receiveShot (shot)
            if (shot > @shieldPower)
                return ShotResult::DONOTRESIST
            else
                return ShotResult::RESIST 
            end 
        end

        # to_s
        def to_s
            return getUIversion().to_s
        end
      
    end
end