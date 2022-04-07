#!/usr/bin/env ruby
#encoding:utf-8

require_relative 'Hangar'
require_relative 'EnemyStarShip'
require_relative 'Damage'
require_relative 'GameUniverse'
require_relative 'SpaceStation'
require_relative 'DamageToUI'
require_relative 'EnemyToUI'
require_relative 'HangarToUI'
require_relative 'SpaceStationToUI'
<<<<<<< HEAD
=======
require_relative 'GameStateController'
require_relative 'SuppliesPackage'
>>>>>>> b56c07a8099700aa36fee02faffb2aadc4b580b0
require_relative 'Loot'

#Class for test main program for second practice
#
#@author Javier Gomez Lopez

class TestP2

<<<<<<< HEAD
=======
    include DeepSpace

>>>>>>> b56c07a8099700aa36fee02faffb2aadc4b580b0
    def self.main
        #Testing Hangar Class
        puts "TESTING Class: Hangar (3 times)"
        puts "**********************************"

        3.times do 
            maxElements = rand(10)
            puts "Creating Hangar.new(#{maxElements})"
            hangar_test = DeepSpace::Hangar.new(maxElements)
            puts "Result: "
            puts hangar_test
            
            puts

            puts "Adding seven different weapons"
            i = 0
            7.times do
                i += 1
                name = "Weapon#{i}"
                type = [DeepSpace::WeaponType::LASER, DeepSpace::WeaponType::MISSILE, DeepSpace::WeaponType::PLASMA][rand(3)]
                uses = rand(10)
                weapon = DeepSpace::Weapon.new(name,type,uses)
                puts "Trying to add: #{weapon}"

                if hangar_test.addWeapon(weapon) == false
                    puts "\t#{name} cannot be added on iteration #{i}"
                else
                    puts "\t#{name} can be added on iteration #{i}"
                end
            end

            puts

            puts "Hangar state is: #{hangar_test.to_s}"
            puts
            puts "Removing three weapons"
            3.times do
                removed_weapon = hangar_test.removeWeapon(0)
                puts "\tWeapon removed: #{removed_weapon}"
            end

            puts
            puts "Hangar state is:"
            puts hangar_test

            puts

            puts "Adding seven different shield boosters"
            i = 0
            7.times do
                i += 1
                name = "Shield#{i}"
                boost = rand(9) + rand()
                uses = rand(10)
                shield = DeepSpace::ShieldBooster.new(name, boost, uses)
                puts "Trying to add #{shield}"

                if hangar_test.addShieldBooster(shield) == false
                    puts "\t#{name} cannot be added on iteration #{i}"
                else
                    puts "\t#{name} can be added on iterarion #{i}"
                end
            end

            puts

            puts "Hangar state is:"
            puts hangar_test

            puts 

            puts "Removing two shields"
            2.times do
                removed_shield = hangar_test.removeShieldBooster(0)
                puts "\tShield removed: #{removed_shield}"
            end

            puts

            puts "Testing getters..."
            puts "\tWeapons: [#{hangar_test.weapons.join(", ")}]"
            puts "\tShields: [#{hangar_test.shieldBoosters.join(", ")}]"
            puts "\tMax elements: #{hangar_test.maxElements}"
            puts "\tUI Version: #{hangar_test.getUIversion}"
            puts
        end

        #Testing Damage Class
        puts "TESTING Class: Damage (3 times)"
        puts "**********************************"

        3.times do
            puts "Creating both types of damage..."
            nWeapons = rand(10)
            nShields = rand(10)

            puts

            puts "Creating Damage.newNumericWeapons(#{nWeapons}, #{nShields})"
            damage_numeric = DeepSpace::Damage.newNumericWeapons(nWeapons, nShields)
            weapons = []

            4.times do
                weapons << [DeepSpace::WeaponType::LASER, DeepSpace::WeaponType::MISSILE, DeepSpace::WeaponType::PLASMA][rand(3)]
            end

            nShields = rand(10)
            puts "Creating Damage.newSpecificWeapons([#{weapons.join(", ")}],#{nShields})"
<<<<<<< HEAD
                weapons << [DeepSpace::WeaponType::LASER, DeepSpace::WeaponType::MISSILE, DeepSpace::WeaponType::PLASMA][rand(3)]
                damage_specific = DeepSpace::Damage.newSpecificWeapons(weapons, nShields)
=======
            damage_specific = DeepSpace::Damage.newSpecificWeapons(weapons, nShields)
>>>>>>> b56c07a8099700aa36fee02faffb2aadc4b580b0

            puts

            puts "Numeric Damage:"
            puts "\t#{damage_numeric}"
            puts
            puts "Specific Damage:"
            puts "\t#{damage_specific}"
            puts 
            puts "UI version numeric: #{damage_numeric.getUIversion}"
            puts "UI version specific: #{damage_specific.getUIversion}"
            puts

            puts "Creating a copy of Numeric Damage"
            copy_test = DeepSpace::Damage.newCopy(damage_numeric)
            puts "Copied Damage: #{copy_test}"
            puts

            puts "Creating a copy of a Specific Damage"
            copy_test = DeepSpace::Damage.newCopy(damage_specific)
            puts "Copied Specific Damage: #{copy_test}"
            puts

            puts "Testing adjust method"

            adjust_weapons = []
            shields_adjust = []

            adjust_weapons << DeepSpace::Weapon.new("First Weapon", DeepSpace::WeaponType::LASER, 3)
            adjust_weapons << DeepSpace::Weapon.new("Second Weapon", DeepSpace::WeaponType::MISSILE, 5)
            adjust_weapons << DeepSpace::Weapon.new("Third Weapon", DeepSpace::WeaponType::PLASMA, 2)

            shields_adjust << DeepSpace::ShieldBooster.new("First Shield", 3.4, 3)
            shields_adjust << DeepSpace::ShieldBooster.new("Second shield", 6, 1)

            puts "damage_numeric.adjust([#{adjust_weapons.join(", ")}],[#{shields_adjust.join(", ")}])"
            puts
            puts "Damage before adjust:"
            puts damage_numeric
            puts "Damage after adjust:"
            puts damage_numeric.adjust(adjust_weapons,shields_adjust)
            puts

            puts "damage_specific.adjust([#{adjust_weapons.join(",")}],[#{shields_adjust.join(", ")}]"
            puts
            puts "Damage before adjust:"
            puts damage_specific
            puts "Damage after adjust:"
            puts damage_specific.adjust(adjust_weapons,shields_adjust)
            puts

            puts "Testing hasNoEffect"
            puts "Has no effect (numeric damage): #{damage_numeric.hasNoEffect}"
            noEffect = DeepSpace::Damage.newNumericWeapons(0,0)
            puts "Has no effect (empty damage): #{noEffect.hasNoEffect}"
            puts

            puts "Testing discardShieldBooster (10 shields)"
            10.times do
                damage_numeric.discardShieldBooster
            end

            puts "Damage Shields: #{damage_numeric.nShields}"

            puts

            puts "Testing discardWeapon (10 weapons)"
            weapon = DeepSpace::Weapon.new("Test Weapon", DeepSpace::WeaponType::PLASMA, 2)
            10.times do 
                damage_numeric.discardWeapon(nil)
                damage_specific.discardWeapon(weapon)
            end

            puts "Numeric Damage Weapons: #{damage_numeric.nWeapons}"
            puts "Specific Damage Weapons: [#{damage_specific.weapons.join(", ")}]"
            puts "--------------"
        end

        #Testing EnemyStarShip Class
        puts "TESTING Class: EnemyStarShip"
        puts "**********************************"

        puts "Creating an enemy starship"
        enemy_test = DeepSpace::EnemyStarShip.new("Enemy Test", 1.12, 3.14, DeepSpace::Loot.new(1,2,3,4,5), DeepSpace::Damage.newNumericWeapons(3,3))

        puts "Enemy starship: \n#{enemy_test}"
        puts

        puts "Crating a copy of the enemy starship"
        enemy_copy = DeepSpace::EnemyStarShip.newCopy(enemy_test)
        puts "Copy: \n#{enemy_copy}"
        puts

        puts "Creating UI Version..."
        enemy_UI = enemy_test.getUIversion
        puts "UI Version: \n#{enemy_UI}"
        puts

        puts "Protection: #{enemy_test.protection}"
        puts "Fire: #{enemy_test.fire}"
        puts

        puts "Testing EnemyStarShip.receiveShot()"
        10.times do |power|
            puts "\tAttacking with #{power} power!"
            result = enemy_test.receiveShot(power)
            puts "\tResult: #{result}"
        end
        puts "--------------"

        #Testing SpaceStation Class
        puts "TESTING Class: SpaceStation"
        puts "**********************************"

        s = DeepSpace::SuppliesPackage.new(0.6,3.14,1.7)
        space_test = DeepSpace::SpaceStation.new("Test Station", s)

        puts "The SpaceStation is:"
        puts space_test
        puts 

        puts "Testing Speed"
        puts "Speed: #{space_test.speed}"
        puts

        puts "With no pendingDamage, is the state valid?: #{space_test.validState}"
        puts

        puts "Testing receive Hangar"
        hangar_station = DeepSpace::Hangar.new(10)
        space_test.receiveHangar(hangar_station)
        puts space_test.hangar
        puts

        puts "Adding some weapons and shieldboosters..."
        puts "Cleaning Hangar..."
        space_test.discardHangar
        hangar_station = DeepSpace::Hangar.new(15)
        space_test.receiveHangar(hangar_station)

        shield_test = DeepSpace::ShieldBooster.new("Shield Test", 3.1415, 4)
        weapon_test = DeepSpace::Weapon.new("Weapon Test", DeepSpace::WeaponType::PLASMA, 2)

        puts space_test.inspect
        puts space_test.hangar.maxElements

        space_test.receiveShieldBooster(shield_test)
        space_test.receiveWeapon(weapon_test)

        puts

        puts "Mounting some weapons and shieldboosters..."
        space_test.mountShieldBooster(0)
        space_test.mountWeapon(0)

        puts "The new Hangar:"
        puts space_test.hangar
        puts

        puts "Mounted Weapons and Shields:"
        puts "\tWeapons: [#{space_test.weapons.join(", ")}]"
        puts "\tShields: [#{space_test.shieldBoosters.join(",")}]"
        puts

        puts "Testing SpaceStation.move()"
        puts "Fuel Units: #{space_test.fuelUnits}"
        puts "Speed: #{space_test.speed}"

        space_test.move

        puts "Fuel units after movement: #{space_test.fuelUnits}"
        puts

        puts "Testing setPendingDamage"
        damage_test = DeepSpace::Damage.newNumericWeapons(2,3)
        space_test.setPendingDamage(damage_test)
        puts "New damage:"
        puts space_test.pendingDamage

        puts "Is the state Valid now?: #{space_test.validState}"
        puts
        
        puts "Restoring Hangar..."
        space_test.discardHangar
        space_test.receiveHangar(hangar_station)

        space_test.receiveShieldBooster(shield_test)
        space_test.receiveWeapon(weapon_test)

        puts space_test.hangar

        puts "Discarting some shields and weapons..."
        space_test.discardShieldBoosterInHangar(0)
        space_test.discardWeaponInHangar(0)

        puts space_test.hangar
        puts


        #Testing GameUniverse Class
        puts "TESTING Class: GameUniverse"
        puts "**********************************"

        puts "We cant test this class because of the nil pointers"
    end #End Main

end #End class

TestP2.main