package deepspace;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class to test the third practice of the subject
 * @author Javier Gomez Lopez
 */
public class TestP3 {
    /**
     * @brief Test of the SpaceStation
     */
    
    private static void testSpaceStation(){
        CardDealer dealer = CardDealer.getInstance();
        
        // Testing SpaceStation
        // ********************************
        System.out.println("Testing SpaceStation");
        System.out.println("****************************");
        int test_number = 0;
        Random rand = new Random();
        
        while(test_number < 3){
            SuppliesPackage supplies_test = new SuppliesPackage(1.05f,3.14f,2.1f);
            SpaceStation station_test = new SpaceStation("SpaceStation test", supplies_test);

            System.out.println("The created SpaceStation is: ");
            System.out.println(station_test);
            System.out.println();

            //Testing setLoot
            System.out.println("Adding a loot to the station");
            Loot loot = new Loot(rand.nextInt(5),rand.nextInt(5),rand.nextInt(5),rand.nextInt(5),rand.nextInt(5));
            System.out.println("The loot to add is: ");
            System.out.println(loot);
            System.out.println();
            
            station_test.setLoot(loot);
            System.out.println("After adding the loot the station is: ");
            System.out.println(station_test);
            System.out.println();
            
            //Testing setPendingDamage
            System.out.println("We are going to add some elements and mount them"
                    + "in order to try setPendingDamage");
            System.out.println();
            
            station_test.mountShieldBooster(0);
            station_test.mountWeapon(0);
            System.out.println("Status of the station: ");
            System.out.println(station_test);
            System.out.println();
            
            System.out.println("Adding some damage to the station...");
            Damage damage = dealer.nextEnemy().getDamage();
            System.out.println("The damage to add is: ");
            System.out.println(damage);
            System.out.println();
            
            station_test.setPendingDamage(damage);
            System.out.println("After adding the damage the state is: ");
            System.out.println(station_test);
            System.out.println("The state of the space station is: "
                + station_test.validState() + "\n");
            
            //Testing cleanUpMountedItems
            
            //With weapons
            System.out.println("Testing SpaceStation.cleanupMountedItems...\n\n");
            
            System.out.println("Using the weapon until making it useless:");
            
            if(station_test.getWeapons() != null){
                if(!station_test.getWeapons().isEmpty() && station_test.getWeapons().get(0) != null){
                    while(station_test.getWeapons().get(0).getUses() > 0){
                        station_test.getWeapons().get(0).useIt();
                    }
                    
                    System.out.println("State before cleaning up mounted items:");
                    System.out.println(station_test);
                    
                    station_test.cleanUpMountedItems();
                    
                    System.out.println("\nState after cleaning up mounted items:");
                    System.out.println(station_test + "\n");
                }
                else{
                    System.out.println("There was no weapon to use\n");
                }
            }
            else{
                System.out.println("There was no weapon ArrayList to access\n");
            }
            
            //With shields
            System.out.println("Using the shield until making it useless:");
            
            if(station_test.getShieldBoosters() != null){
                if(!station_test.getShieldBoosters().isEmpty() && station_test.getShieldBoosters().get(0) != null){
                    while(station_test.getShieldBoosters().get(0).getUses() > 0){
                        station_test.getShieldBoosters().get(0).useIt();
                    }
                    
                    System.out.println("State before cleaning up mounted items:");
                    System.out.println(station_test);
                    
                    station_test.cleanUpMountedItems();
                    
                    System.out.println("\nState after cleaning up mounted items;");
                    System.out.println(station_test + "\n");
                }
                else{
                    System.out.println("There was no shieldBooster to use\n");
                }
            }
            else{
                System.out.println("There was no ShieldBooster ArrayList to access\n");
            }
            
            System.out.println();
            
            //Testing discardShieldBooster and discardWeapon
            System.out.println("We add some elements and mount them in order to discard them later");
            loot = new Loot(2,2,2,2,2);
            
            station_test.setLoot(loot);
            station_test.mountShieldBooster(0);
            station_test.mountWeapon(0);
            
            System.out.println("State of the station: ");
            System.out.println(station_test + "\n");
            
            System.out.println("Discarding a shieldBooster...");
            station_test.discardShieldBooster(0);
            System.out.println("\nState of the station after discarding a shieldBooster:");
            System.out.println(station_test + "\n");
            
            System.out.println("Discarding a weapon...");
            station_test.discardWeapon(0);
            System.out.println("\nState of the station after discarding a weapon:");
            System.out.println(station_test + "\n");
            
            //Testing space station actions
            System.out.println("\nAdding some elements and mounting them in order"
                    + "to make some actions");
            loot = new Loot(3,3,3,3,3);
            
            station_test.setLoot(loot);
            station_test.mountShieldBooster(0);
            station_test.mountWeapon(0);
            System.out.println("\nState of the station:");
            System.out.println("\n" + station_test);
            
            System.out.println();
            
            System.out.println("Fire: " + station_test.fire());
            System.out.println("Protect: " + station_test.protection());
            System.out.println("\nState of the station:");
            System.out.println(station_test);
            System.out.println();
            
            //Receiving some shots
            for(int i = 1; i < 100; i = i + 10){
                System.out.println("Result of receiving a shot of power " +
                        i + ": " + station_test.receiveShot(i));
            }
            
            System.out.println("-----------");
            System.out.println();
            
            test_number++;
        }
    }
    
    /**
     * @brief Test of the GameUniverse
     */
    
    private static void testGameUniverse(){
        // Testing SpaceStation
        // ********************************
        System.out.println("Testing SpaceStation");
        System.out.println("****************************");
        
        int test_number = 0;
        while(test_number < 3){
            //Testing the constructor
            GameUniverse universe_test = new GameUniverse();
            System.out.println("The created GameUniverse is:");
            System.out.println(universe_test + "\n");
            
            System.out.println("The current state of the game is: " + universe_test.getState());
            System.out.println();
            
            //Testing init
            System.out.println("Testing the init method for players Javi and Roberto");
            ArrayList<String> player_names = new ArrayList<>();
            player_names.add("Javi");
            player_names.add("Roberto");
            
            System.out.println("The players are: " + player_names);
            
            universe_test.init(player_names);
            System.out.println("After starting the game the universe state is: ");
            System.out.println(universe_test);
            
            //Testing the state of the game and the haveAWinner
            System.out.println("The current state of the game is: " + universe_test.getState());
            System.out.println("Have we got a winner?: " + universe_test.haveAWinner());
            System.out.println();
            
            //Testing combat
            System.out.println("Testing the combat:");
            CombatResult result_test = universe_test.combat();
            System.out.println("\nThe result of the combat was: " + result_test);
            System.out.println("\nState of the game:");
            System.out.println(universe_test);
            System.out.println();
            
            //Testing nextTurn
            System.out.println("Testing next turn");
            universe_test.nextTurn();
            System.out.println("State after next turn:");
            System.out.println(universe_test);
            System.out.println();
            
            System.out.println("-----------");
            System.out.println();
            test_number++;
        }
        
    }
    
    public static void main(String[] args){
        testSpaceStation();
        //testGameUniverse();
    }
    
}