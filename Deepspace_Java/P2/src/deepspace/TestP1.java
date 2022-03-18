/**
 * @author BOLÍVAR PELÁEZ, CLARA
 * @author RUIZ GÓMEZ, SOLEDAD
 * 2º DGIIM - PDOO - Practice 1 DeepSpace
 */
package deepspace;

/**
 * @title TestP1
 * @brief Main program which utility is to test all the classes and methods
 * implemented in this practice
 */


public class TestP1 {
    
    public static void main (String [] args) {
        
        
        System.out.println ("Testing classes and methods from P1\n");
        
        // ENUM
        
        System.out.println ("ENUM: \n");
        
        // CombatResult
        
        System.out.println("CombatResult \n");
        System.out.print(CombatResult.ENEMYWINS + " - ");
        System.out.print(CombatResult.NOCOMBAT + " - ");
        System.out.print(CombatResult.STATIONESCAPES + " - ");
        System.out.println(CombatResult.STATIONWINS);
        System.out.println("\n");
        
        // GameCharacter
        
        System.out.println("GameCharacter \n");
        System.out.print(GameCharacter.ENEMYSTARSHIP + " - ");
        System.out.println(GameCharacter.SPACESTATION);
        System.out.println("\n");
        
        // ShotResult
        
        System.out.println("ShotResult \n");
        System.out.print(ShotResult.DONOTRESIST + " - ");
        System.out.println(ShotResult.RESIST);
        System.out.println("\n");
        
        // CLASSES
        
        System.out.println ("CLASSES: \n");
        
        // WeaponType
        
        System.out.println("WeaponType \n");
        System.out.print(WeaponType.LASER.getPower() + " - ");
        System.out.print(WeaponType.MISSILE.getPower() + " - ");
        System.out.println(WeaponType.PLASMA.getPower());
        System.out.println("\n");
        
        // Loot
        
        Loot loot = new Loot(1,2,3,5,7);
        
        System.out.println("Loot \n");
        System.out.print(loot.getNSupplies() + " - ");
        System.out.print(loot.getNWeapons() + " - ");
        System.out.print(loot.getNShields() + " - ");
        System.out.print (loot.getNHangars() + " - ");
        System.out.println(loot.getNMedals());
        System.out.println("\n");
        
        // SuppliesPackage
        
        SuppliesPackage supplies = new SuppliesPackage(11, 13, 17);
        
        System.out.println("SuppliesPackage \n");
        System.out.print(supplies.getAmmoPower() + " - ");
        System.out.print(supplies.getFuelUnits() + " - ");
        System.out.println(supplies.getShieldPower());
        System.out.println("\n");
        
        // ShieldBooster
        
        ShieldBooster sbooster = new ShieldBooster("Shield", 19.0f, 23);
        
        System.out.println("ShieldBooster \n");
        System.out.print(sbooster.getBoost()+ " - ");
        System.out.print(sbooster.useIt()+ " - ");
        System.out.println(sbooster.getUses());
        System.out.println("\n");
        
        // Weapon
        
        Weapon weapon = new Weapon("Plasma", WeaponType.PLASMA, 29);
        
        System.out.println("Weapon \n");
        System.out.print(weapon.getType() + " - ");
        System.out.print(weapon.power() + " - ");
        System.out.print(weapon.useIt() + " - ");
        System.out.println(weapon.getUses());
        System.out.println("\n");
        
        // Dice
        
        Dice dice = new Dice();
        int MAX = 100;
        
        System.out.println("Dice \n");
        
        // initWithNHangars
        System.out.println("...testing initWithNHangars\n");
        
        int v1 = 0;
        int v2 = 0;
        
        for (int i=0; i<MAX; i++) {
            
            if (dice.initWithNHangars() == 0)
                v1++;
            else 
                v2++;
        }
        
        System.out.println(v1 + " ~ 25\n");
        System.out.println(v2 + " ~ 75\n");
        
        // initWithNWeapons
        System.out.println("...testing initWithNWeapons\n");
        
        v1 = 0;
        v2 = 0;
        int v3 = 0;
        int res;
        
        for (int i=0; i<MAX; i++) {
            
            res = dice.initWithNWeapons();
            if (res == 1)
                v1++;
            else if (res == 2)
                v2++;
            else
                v3++;
           
        }
        
        System.out.println(v1 + " ~ 33\n");
        System.out.println(v2 + " ~ 33\n");
        System.out.println(v3 + " ~ 33\n");
        
        
        // initWithNShields
        System.out.println("...testing initWithNShields\n");
        
        v1 = 0;
        v2 = 0;
        
        for (int i=0; i<MAX; i++) {
            
            if (dice.initWithNShields() == 0)
                v1++;
            else 
                v2++;
        }
        
        System.out.println(v1 + " ~ 25\n");
        System.out.println(v2 + " ~ 75\n");
        
        // It doesn't make sense to test whoStarts as it is completely random
        
        // firstShot
        System.out.println("...testing firstShot\n");
        
        v1 = 0;
        v2 = 0;
       
        
        for (int i=0; i<MAX; i++) {
            
            if (dice.firstShot() == GameCharacter.SPACESTATION)
                v1++;
            else 
                v2++;
        }
        
        System.out.println(v1 + " ~ 50\n");
        System.out.println(v2 + " ~ 50\n");
        
        
        // spaceStationMoves
        System.out.println("...testing spaceStationMoves\n");
        
        float speed = 0.4f; // This value can be modified
        
        v1 = 0;
        v2 = 0;
        
        for (int i=0; i<MAX; i++) {
            
            if (dice.spaceStationMoves(speed))
                v1++;
            else 
                v2++;
        }
        
        System.out.println(v1 + " ~ " + speed*100 + "\n");
        System.out.println(v2 + " ~ " + (100-speed*100) + "\n");
        
                
    }
        
}
