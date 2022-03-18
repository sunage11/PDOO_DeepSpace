#!/usr/bin/env ruby
#encoding: utf-8

require_relative 'CombatResult'
require_relative 'Dice'
require_relative 'GameCharacter'
require_relative 'Loot'
require_relative 'ShieldBooster'
require_relative 'ShotResult'
require_relative 'SuppliesPackage'
require_relative 'Weapon'
require_relative 'WeaponType'

class TestP1

    def self.main


        puts "Testing classes and methods from P1\n\n"

        # ENUM

        puts "ENUM\n\n"

        # CombatResult
        puts "CombatResult\n\n"
        puts DeepSpace::CombatResult::ENEMYWINS 
        puts DeepSpace::CombatResult::NOCOMBAT
        puts DeepSpace::CombatResult::STATIONESCAPES
        puts DeepSpace::CombatResult::STATIONWINS
        puts "\n-\n\n"

        # GameCharacter
        puts "GameCharacter\n\n"
        puts DeepSpace::GameCharacter::ENEMYSTARSHIP
        puts DeepSpace::GameCharacter::SPACESTATION
        puts "\n-\n\n"

        # ShotResult
        puts "ShotResult\n\n"
        puts DeepSpace::ShotResult::DONOTRESIST 
        puts DeepSpace::ShotResult::RESIST
        puts "\n\n"

        # CLASSES

        puts "-------"
        puts "\n\nCLASSES\n\n"

        # WeaponType

        puts "WeaponType\n\n"
        puts DeepSpace::WeaponType::LASER.power()
        puts DeepSpace::WeaponType::MISSILE.power()
        puts DeepSpace::WeaponType::PLASMA.power()
        puts "\n-\n\n"

        # Loot

        puts "Loot\n\n"

        loot = DeepSpace::Loot.new(1,2,3,5,7)

        puts loot.nSupplies()
        puts loot.nWeapons()
        puts loot.nShields()
        puts loot.nHangars()
        puts loot.nMedals()
        puts "\n-\n\n"

        # SuppliesPackage

        puts "SuppliesPackage\n\n"

        supplies = DeepSpace::SuppliesPackage.new(11, 13, 17)
        
        puts supplies.ammoPower()
        puts supplies.fuelUnits()
        puts supplies.shieldPower()
        puts "\n-\n\n"

        # ShieldBooster

        puts "ShieldBooster\n"

        sbooster = DeepSpace::ShieldBooster.new("Shield", 19.0, 23)

        puts sbooster.boost()
        puts sbooster.useIt()
        puts sbooster.uses()
        puts "\n-\n\n"

        # Weapon

        puts "Weapon\n"

        weapon = DeepSpace::Weapon.new("Plasma", DeepSpace::WeaponType::PLASMA, 29)
        
        puts weapon.type()
        puts weapon.power()
        puts weapon.useIt()
        puts weapon.uses()
        puts "\n-\n\n"

        # Dice

        puts "Dice\n"

        dice = DeepSpace::Dice.new
        max=100

        # -> initWithNHangars

        i = 0
        v1 = 0
        v2 = 0

        puts "...testing initWithNHangars\n"

        while i<max

            if dice.initWithNHangars == 0
                v1 += 1
            else
                v2 += 1
            end

            i += 1

        end

        puts v1.to_s + " ~ 25\n"
        puts v2.to_s + " ~ 75\n"

        # -> initWithNWeapons

        i = 0
        v1 = 0
        v2 = 0
        v3 = 0

        puts "\n...testing initWithNWeapons\n"

        while i<max

            prob = dice.initWithNWeapons

            if  prob == 1
                v1 += 1
            else
                if prob == 2
                    v2 += 1
                else
                    v3 +=1
                end
            end

            i +=1 

        end

        puts v1.to_s + " ~ 33\n"
        puts v2.to_s + " ~ 33\n"
        puts v3.to_s + " ~ 33\n"

        # -> initWithNShields

        i = 0
        v1 = 0
        v2 = 0

        puts "\n...testing initWithNShields\n"

        while i<max

            if dice.initWithNShields == 0
                v1 += 1
            else
                v2 += 1
            end

            i += 1

        end

        puts v1.to_s + " ~ 25\n"
        puts v2.to_s + " ~ 75\n"

        # -> firstShot

        i = 0
        v1 = 0
        v2 = 0

        puts "\n...testing firstShot\n"

        while i<max

            if dice.firstShot == DeepSpace::GameCharacter::SPACESTATION
                v1 += 1
            else
                v2 += 1
            end

            i += 1

        end

        puts v1.to_s + " ~ 50\n"
        puts v2.to_s + " ~ 50\n"

        # -> spaceStationMoves

        i = 0
        v1 = 0
        v2 = 0
        speed = 0.4

        puts "\n...testing spaceStationMoves\n"

        while i<max

            if dice.spaceStationMoves (speed) 
                v1 += 1
            else
                v2 += 1
            end

            i += 1
            
        end

        puts v1.to_s + " ~ " + (speed*100).to_s + "\n"
        puts v2.to_s + " ~ " + (100-speed*100).to_s + "\n"

    end
end
        
TestP1.main





