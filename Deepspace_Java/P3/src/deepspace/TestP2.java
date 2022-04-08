/**
 * @author BOLÍVAR PELÁEZ, CLARA
 * @author RUIZ GÓMEZ, SOLEDAD
 * 2º DGIIM - PDOO - Practice 2 DeepSpace
 */
package deepspace;
import java.util.ArrayList;

/**
 * @title TestP2
 * @brief Main program which utility is to test all the classes and methods
 * implemented in this practice
 */

public class TestP2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        //Probamos la clase Hangar
        
        System.out.println("Probando clase Hangar\n");
        Hangar hangar = new Hangar(4);
        System.out.println(hangar.getMaxElements());
        System.out.println("\n");
        System.out.println(hangar.getShieldBoosters());
        System.out.println("\n");
        System.out.println(hangar.getWeapons());
        System.out.println("\n");
        Weapon armaas = new Weapon("laser", WeaponType.LASER, 8);
        Weapon arma3 = new Weapon("misil", WeaponType.MISSILE, 10);
        hangar.addWeapon(armaas);
        hangar.addWeapon(arma3);
        Hangar aux = new Hangar(hangar);
        ShieldBooster escudoss = new ShieldBooster("prueba", 1, 1);
        hangar.addShieldBooster(escudoss);
        hangar.addShieldBooster(escudoss);
        System.out.println(hangar.getWeapons());
        System.out.println("\n");
        System.out.println(hangar.getShieldBoosters());
        System.out.println("\n");
        System.out.println(hangar.toString());
        System.out.println("\n");
        hangar.removeWeapon(1);
        System.out.println(hangar.getWeapons());
        System.out.println("\n");
        hangar.removeShieldBooster(0);
        System.out.println(hangar.getShieldBoosters());
        System.out.println("\n");
        Hangar hangar2 = new Hangar(hangar);
        System.out.println(hangar2.toString());
        System.out.println("\n");

        
        
        //Probamos la clase Damage
        System.out.println("\n");
        
        System.out.println("Probando clase Damage");
        System.out.println("\n");
        Damage damage = new Damage(2, 2);
        System.out.println(damage.getNShields());
        System.out.println("\n");
        System.out.println(damage.getNWeapons());
        System.out.println("\n");
        System.out.println(damage.getWeapons());
        System.out.println("\n");
        System.out.println(damage.toString());
        System.out.println("\n");
        Weapon arma1 = new Weapon("laser", WeaponType.LASER, 8);
        Weapon arma2 = new Weapon("misil", WeaponType.MISSILE, 10);
        ArrayList<Weapon> armas = new ArrayList<>();
        armas.add(arma1);
        armas.add(arma2);
        ArrayList<WeaponType> arma = new ArrayList<>();
        arma.add(arma1.getType());
        arma.add(arma2.getType());
        Damage damage2 = new Damage(arma, 3);
        ShieldBooster escudo = new ShieldBooster("name", 2, 2);
        ArrayList<ShieldBooster> escudos = new ArrayList<>();
        escudos.add(escudo);
        System.out.println(damage2.getNShields());
        System.out.println("\n");
        System.out.println(damage2.getNWeapons());
        System.out.println("\n");
        System.out.println(damage2.getWeapons());
        System.out.println("\n");
        Damage damage3 = new Damage(damage2);
        System.out.println(damage3.toString());
        System.out.println("\n");
        System.out.println(damage.hasNoEffect());
        System.out.println("\n");
        Damage damage4 = new Damage(damage2.adjust(armas, escudos));
        System.out.println("-----------");
        System.out.println("\n");
        System.out.println(damage2.toString());
        System.out.println("\n");
        System.out.println(damage4.toString());
        System.out.println("\n");
        System.out.println("-----------");
        System.out.println(damage.getNWeapons());
        System.out.println("\n");
        damage.discardWeapon(arma1);
        System.out.println(damage.getNWeapons());
        System.out.println("\n");
        System.out.println(damage2.getWeapons());
        System.out.println("\n");
        damage2.discardWeapon(arma1);
        System.out.println(damage2.getWeapons());
        System.out.println("\n");
        System.out.println(damage.getNShields());
        System.out.println("\n");
        damage.discardShieldBooster();
        System.out.println(damage.getNShields());
        System.out.println("\n");

        
        //Probamos la clase EnemyStarShip
        System.out.println("\n");
        
        System.out.println("Probando EnemyStarShip");
        System.out.println("\n");
        Loot loot = new Loot(1,2,3,4,5);
        Damage damagee = new Damage(2,2);
        EnemyStarShip enemy = new EnemyStarShip("Prueba", 2.0f, 3.0f, loot, damagee);
        System.out.println(enemy.getName());
        System.out.println("\n");
        System.out.println(enemy.getAmmoPower());
        System.out.println("\n");
        System.out.println(enemy.getShieldPower());
        System.out.println("\n");
        System.out.println(enemy.getLoot());
        System.out.println("\n");
        System.out.println(enemy.getDamage());
        System.out.println("\n");
        System.out.println(enemy.toString());
        System.out.println("\n");
        System.out.println(enemy.protection());
        System.out.println("\n");
        System.out.println(enemy.fire());
        System.out.println("\n");
        System.out.println(enemy.receiveShot(2.0f));
        System.out.println("\n");
        
        
        //Probamos la clase SpaceStation
        System.out.println("\n");
        
        System.out.println("Probando SpaceStation");
        System.out.println("\n");
        SuppliesPackage supplies = new SuppliesPackage(1, 2, 3);
        SpaceStation space = new SpaceStation("prueba", supplies);
        System.out.println(space.getName());
        System.out.println("\n");
        System.out.println(space.getAmmoPower());
        System.out.println("\n");
        System.out.println(space.getFuelUnits());
        System.out.println("\n");
        System.out.println(space.getShieldPower());
        System.out.println("\n");
        System.out.println(space.getNMedals());
        System.out.println("\n");
        space.setPendingDamage(damage);
        System.out.println(space.getPendingDamage());
        System.out.println("\n");
        System.out.println(space.getWeapons());
        System.out.println("\n");
        System.out.println(space.getShieldBoosters());
        System.out.println("\n");
        space.receiveHangar(aux);
        System.out.println(space.getHangar());
        System.out.println("\n");
        System.out.println(space.toString());
        System.out.println("\n");
        Hangar hangar4 = new Hangar(4);
        Weapon armita = new Weapon("arma", WeaponType.LASER, 8);
        ShieldBooster escudito = new ShieldBooster("escudo", 1, 1);
        System.out.println("-----------");
        System.out.println("\n");
        System.out.println(space.receiveWeapon(armita));
        System.out.println("\n");
        System.out.println(space.receiveShieldBooster(escudito));
        System.out.println("\n");
        System.out.println("-----------");
        System.out.println("\n");
        space.receiveHangar(hangar4);
        System.out.println(space.receiveWeapon(armita));
        System.out.println("\n");
        System.out.println(space.receiveShieldBooster(escudito));
        System.out.println("\n");
        System.out.println(space.getHangar());
        System.out.println("\n");
        System.out.println("-----------");
        System.out.println("\n");
        space.mountShieldBooster(0);
        space.mountWeapon(0);
        System.out.println(space.getHangar());
        System.out.println("\n");
        System.out.println(space.getShieldBoosters());
        System.out.println("\n");
        System.out.println(space.getWeapons());
        System.out.println("\n");
        space.receiveHangar(aux);
        System.out.println(space.getHangar());
        System.out.println("\n");
        System.out.println("-----------");
        System.out.println("\n");
        space.receiveHangar(hangar4);
        System.out.println(space.receiveWeapon(armita));
        System.out.println("\n");
        System.out.println(space.receiveShieldBooster(escudito));
        System.out.println("\n");
        System.out.println(space.getHangar());
        System.out.println("\n");
        space.discardShieldBoosterInHangar(0);
        space.discardWeaponInHangar(0);
        System.out.println(space.getHangar());
        System.out.println("\n");
        System.out.println(space.getSpeed());
        System.out.println("\n");
        System.out.println(space.getFuelUnits());
        System.out.println("\n");
        space.move();
        System.out.println(space.getFuelUnits());
        System.out.println("\n");
        System.out.println("-----------");
        System.out.println("\n");
        Weapon wp = new Weapon("arma", WeaponType.PLASMA, 0);
        System.out.println(space.receiveWeapon(wp));
        System.out.println("\n");
        space.mountWeapon(0);
        System.out.println(space.getWeapons());
        System.out.println("\n");
        space.cleanUpMountedItems();
        System.out.println(space.getWeapons());
        System.out.println("\n");
        System.out.println(space.validState());
        System.out.println("\n");
        System.out.println("-----------");
        System.out.println("\n");
        System.out.println(space.getShieldPower());
        System.out.println("\n");
        System.out.println(space.getWeapons());
        System.out.println("\n");
        Damage damagito = new Damage(2,2);
        space.setPendingDamage(damagito);
        System.out.println(space.getPendingDamage());
        System.out.println("\n");
        System.out.println(space.validState());
        System.out.println("\n");
        System.out.println("\n");
    }
    
}
