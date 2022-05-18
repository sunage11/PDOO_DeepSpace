/**
 * @author BOLÍVAR PELÁEZ, CLARA
 * @author RUIZ GÓMEZ, SOLEDAD
 * 2º DGIIM - PDOO - Practice 1 DeepSpace
 */
package deepspace;


import java.util.ArrayList;
import java.util.Random;

/**
 * Class to test the fourth practice of the subject
 *
 * @author Javier Gomez Lopez
 */
public class TestsP4 {
    
    /**
     * @brief Test of Numeric Damage
     */
    
    private static void testNumericDamage(){
        System.out.println("Testing NumericDamage");
        System.out.println("****************************");
        
        int test_number = 0;
        Random rand = new Random();
        
        while(test_number < 3){
            test_number++;
            
            CardDealer dealer = CardDealer.getInstance();
            ArrayList<Weapon> w = new ArrayList<>();
            ArrayList<ShieldBooster> s = new ArrayList<>();

            w.add(dealer.nextWeapon());
            s.add(dealer.nextShieldBooster());
            
            int w_num = rand.nextInt(4) + 1;
            int s_num = rand.nextInt(4) + 1;
            
            NumericDamage numeric_test = new NumericDamage(w_num, s_num);
            System.out.println("Creating new NumericDamage(" + w_num + "," + s_num + ")");
            System.out.println("The state of the new Numeric Damage is: " + numeric_test);
            System.out.println();
            
            System.out.println("Creating a copy of the numeric damage...");
            NumericDamage copy_test = numeric_test.copy();
            System.out.println("State of the copy: " + copy_test);
            System.out.println();
            
            System.out.println("Testing hasNoEffect()...");
            System.out.println("Our Damage hasNoEffect: " + numeric_test.hasNoEffect());
            System.out.println("NumericDamage(0,0) hasNoEffect: " + new NumericDamage(0,0).hasNoEffect());
            System.out.println();
            
            System.out.println("Discarding a shield booster...");
            numeric_test.discardShieldBooster();
            System.out.println("State after discarding a shieldBooster: \n" + numeric_test);
            System.out.println();
            
            System.out.println("Testing adjust");
            System.out.println("Weapon List: " + w);
            System.out.println("Shield List: " + s);
            numeric_test = numeric_test.adjust(w, s);
            System.out.println("State after adjusting: \n" + numeric_test);
            System.out.println();
            
            System.out.println("UI version: " + numeric_test.getUIversion());
            System.out.println();
            
            System.out.println("State of the original version: \n"  + numeric_test);
            System.out.println("State of the copy:\n" + copy_test);
            System.out.println("****************************");
            System.out.println();
            
        }
    }
    
    /**
     * @brief Test of Specific Damage
     */
    
    private static void testSpecificDamage(){
        System.out.println("Testing SpecificDamage");
        System.out.println("****************************");
        
        int test_number = 0;
        Random rand = new Random();
        
        while(test_number < 3){
            test_number++;
            ArrayList<WeaponType> weapon_list = new ArrayList<>();
            weapon_list.add(WeaponType.LASER);
            int s_num = rand.nextInt(5);
            
            SpecificDamage specific_test = new SpecificDamage(weapon_list, s_num);
            
            System.out.println("Creating new SpecificDamage(" + weapon_list + "," + s_num + ")");
            System.out.println("The state of the new Specific Damage is:" );
            System.out.println(specific_test);
            System.out.println();
            
            System.out.println("Creating a copy of the specific damage...");
            SpecificDamage copy_test = specific_test.copy();
            System.out.println("State of the copy: \n" + copy_test);
            System.out.println();
            
            System.out.println("Testing hasNoEffect()");
            System.out.println("Our Damage hasNoEffect(): " + specific_test.hasNoEffect());
            System.out.println("SpecificTest(null,0) hasNoEffect: " + new SpecificDamage(null,0).hasNoEffect());
            System.out.println();
            
            System.out.println("UI Version: " + specific_test.getUIversion());
            System.out.println();
            
            System.out.println("Testing adjust...");
            CardDealer dealer = CardDealer.getInstance();
            ArrayList<Weapon> w = new ArrayList<>();
            ArrayList<ShieldBooster> s = new ArrayList<>();
            
            w.add(dealer.nextWeapon());
            s.add(dealer.nextShieldBooster());
            
            System.out.println("State before adjust: \n" + specific_test);
            
            specific_test = specific_test.adjust(w, s);
            System.out.println("Weapons to adjust: " + w);
            System.out.println("Shields to adjust: " + s);
            System.out.println("State after the adjust:\n" + specific_test);
            System.out.println();
            
            System.out.println("Testing discard weapon");
            Weapon test_w_1 = new Weapon("Weapon1", WeaponType.LASER, 3);
            Weapon test_w_2 = new Weapon("Weapon2", WeaponType.PLASMA, 2);
            System.out.println("Discarding a PLASMA...");
            specific_test.discardWeapon(test_w_2);
            System.out.println("State of the damage: \n" + specific_test);
            System.out.println("Discarding a LASER...");
            specific_test.discardWeapon(test_w_1);
            System.out.println("State of the damage: \n" + specific_test);
            System.out.println();
            
            System.out.println("Discarding a shield booster...");
            specific_test.discardShieldBooster();
            System.out.println("State of the damage: \n" + specific_test);
            System.out.println();
            
            System.out.println("State of the original damage:\n" + specific_test);
            System.out.println("State of the copy: \n" + copy_test);
            
            System.out.println("****************************");
            System.out.println();
        }
        
    }
    
    /**
     * @brief Test of SpaceCity
     */
    
    private static void testSpaceCity(){
        System.out.println("Testing SpaceCity");
        System.out.println("****************************");
        
        SuppliesPackage base = new SuppliesPackage(1.23f, 3.14f, 2.22f);
        SpaceStation javi = new SpaceStation("Javi", base);
        SpaceStation soledad = new SpaceStation("Soledad", base);
        SpaceStation roberto = new SpaceStation("Roberto", base);
        
        ArrayList<SpaceStation> collaborators = new ArrayList<>();
        collaborators.add(soledad);
        collaborators.add(roberto);
        
        SpaceCity city_test = new SpaceCity(javi, collaborators);
        System.out.println("The created SpaceCity is: \n" + city_test);
        System.out.println();
        
        System.out.println("Firing with a power of " + city_test.fire());        
        System.out.println("Protecting with a power of: " + city_test.protection());
        System.out.println();
        
        Loot loot_test = new Loot(1,2,3,4,5,false,true);
        System.out.println("Adding the loot: " + loot_test);
        city_test.setLoot(loot_test);
        System.out.println("State of the city: \n" + city_test);
        System.out.println();
        
        System.out.println("****************************");
        System.out.println();
        
    }
    
    /**
     * @brief Test of PowerEfficientStation
     */
    
    private static void testPowerEfficientStation(){
        System.out.println("Testing PowerEfficientSpaceStation");
        System.out.println("****************************");
        
        SuppliesPackage base = new SuppliesPackage(1.23f, 3.14f, 2.22f);
        SpaceStation station_test = new SpaceStation("Javi", base);
        PowerEfficientSpaceStation power_test = new PowerEfficientSpaceStation(station_test);
        System.out.println("The created power efficient station is: \n"+ power_test );
        System.out.println();
        
        System.out.println("The station fire: " + power_test.fire());
        System.out.println("The station protects: " + power_test.protection());
        System.out.println();
        
        Loot loot_test = new Loot(1,2,3,4,5,false,true);
        System.out.println("Adding the loot: " + loot_test);
        Transformation trans_test = power_test.setLoot(loot_test);
        System.out.println("Transformation returned: " + trans_test);
        System.out.println("State of the power efficient station: \n" + power_test);
        System.out.println();
        
        System.out.println("****************************");
        System.out.println();
        
    }
    
    /**
     * @brief Test of BetaPowerEfficientStation
     */
    
    private static void testBetaPowerEfficientStation(){
        System.out.println("Testing BetaPowerEfficientSpaceStation");
        System.out.println("****************************");
        
        SuppliesPackage base = new SuppliesPackage(1.23f, 3.14f, 2.22f);
        SpaceStation station_test = new SpaceStation("Javi", base);
        
        BetaPowerEfficientSpaceStation beta_test = new BetaPowerEfficientSpaceStation(station_test);
        System.out.println("The created beta power efficient station is: \n" + beta_test);
        
        System.out.println("Firing a few times");
        for(int i = 0; i < 5; i++){
            System.out.println("\nThe station fires: " +  beta_test.fire());
        }
        
        System.out.println();
        
        System.out.println("****************************");
        System.out.println();
        
    }
    
    
    public static void main(String[] args){
        //testNumericDamage();
        //testSpecificDamage();
        //testSpaceCity();
        //testPowerEfficientStation();
        //testBetaPowerEfficientStation();
    }
    
}


