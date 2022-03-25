/**
 * @author BOLÍVAR PELÁEZ, CLARA
 * @author RUIZ GÓMEZ, SOLEDAD
 * 2º DGIIM - PDOO - Practice 2 DeepSpace
 */
package deepspace;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author sunage
 */
public class SpaceStation {
    
    private final int MAXFUEL = 100; //Shield units that are lost for each 
    //unit of firing power received.
    private final int SHIELDLOSSPERUNITSHOT = 100; //Greatest number of fuel 
    //units that a space station can have.
    
    private float ammoPower;
    private float fuelUnits;
    private String name;
    private int nMedals;
    private float shieldPower;
    private Damage pendingDamage;
    private ArrayList<Weapon> weapons;
    private ArrayList<ShieldBooster> shieldBoosters;
    private Hangar hangar;
    
    
    /**
    * @brief Set the amount of fuel to the value passed without ever 
    * exceeding the limit.
    * @param f value 
    */
    void assignFuelValue (float f) {
        if (f<=MAXFUEL)
            fuelUnits = f;
        else
            fuelUnits = MAXFUEL;
    }
    
    /**
    * @brief Set pending damage to null if it has no effect.
    */
    void cleanPendingDamage () {
        if(pendingDamage.hasNoEffect())
            pendingDamage = null;
    }
    
    /**
    * @brief Constructor
    * @param n name
    * @param supplies a instance os SuppliesPackage
    */
    protected SpaceStation (String n, SuppliesPackage supplies) {
        ammoPower = supplies.getAmmoPower();
        fuelUnits = supplies.getFuelUnits();
        shieldPower = supplies.getShieldPower();
        name = n;
        nMedals = 0;
        pendingDamage= null;
        hangar = null;
        weapons = new ArrayList<>();
        shieldBoosters = new ArrayList<>();
    }
    
    /**
    * @brief It eliminates all mounted weapons and boosters that do not have 
    * any use left.
    */
    void cleanUpMountedItems () {
        
        Iterator<Weapon> it = weapons.iterator();
        Iterator<ShieldBooster> it2 = shieldBoosters.iterator();
        
        while(it.hasNext()){
            Weapon aux = it.next();
            if(aux.getUses() == 0)
                weapons.remove(aux);
        }
        
        while(it2.hasNext()){
            ShieldBooster aux2 = it2.next();
            if(aux2.getUses() == 0)
                shieldBoosters.remove(aux2);
        }
        
        
    }
    
    /**
    * @brief Set the reference of the hangar to null to indicate that it 
    * is not available.
    */
    void discardHangar () {
        hangar = null;
    }
    
    /**
    * @brief 
    * @param 
    */
    void discardShieldBooster (int i) {
        //Se hace en la práctica 3
    }
    
    /**
    * @brief If a hangar is available, it is requested to discard the booster 
    * with index i.
    * @param i index
    */
    void discardShieldBoosterInHangar (int i) {
        if(hangar!=null)
            hangar.removeShieldBooster(i);
    }
    
    /**
    * @brief Copy constructor
    * @param d another Damage instance
    */
    void discardWeapon (int i) {
        //Se hace en la práctica 3
    }
    
    /**
    * @brief If a hangar is available, it is requested to discard the weapon 
    * with index i.
    * @param i index
    */
    void discardWeaponInHangar (int i) {
        if(hangar!=null)
            hangar.removeWeapon(i);
        
    }
    
    /**
    * @brief Copy constructor
    * @param d another Damage instance
    */
    float fire () {
        //Se hace en la práctica 3
    }
    
    /**
    * @brief Copy constructor
    * @param d another Damage instance
    */
    void discardWeaponInHangar (int i) {
        
    }
    
    /**
    * @brief Getter with package visibility
    * @return ammoPower value
    */
    float getAmmoPower () {
        return (ammoPower);
    }
    
    /**
    * @brief Getter with package visibility
    * @return fuelUnits value
    */
    float getFuelUnits () {
        return (fuelUnits);
    }
    
    /**
    * @brief Getter with package visibility
    * @return Hangar instance
    */
    Hangar getHangar () {
        return (hangar);
    }
    
    /**
    * @brief Getter with package visibility
    * @return name value
    */
    String getName () {
        return (name);
    }
    
    /**
    * @brief Getter with package visibility
    * @return nMedals value 
    */
    int getNMedals () {
        return(nMedals);
    }
    
    /**
    * @brief Getter with package visibility
    * @return pendingDamage instance
    */
    Damage getPendingDamage () {
        return (pendingDamage);
    }
    
    /**
    * @brief Getter with package visibility
    * @return collection of ShieldBoosters
    */
    ArrayList<ShieldBooster> getShieldBooster () {
        return(shieldBoosters);
    }
    
    /**
    * @brief Getter with package visibility
    * @return shieldPower instance
    */
    float getShieldPower () {
        return (shieldPower);
    }
    
    
    /**
    * @brief Getter with package visibility
    * @param d another Damage instance
    */
    float getSpeed () {
        return(fuelUnits/MAXFUEL);
    }
    
    /**
    * @brief builds a new WeaponToUI object from *this
    * @return WeaponToUI
    */
    SpaceStationToUI getUIversion () {
        return new SpaceStationToUI (this);
    }
    
    /**
    * @brief Getter with package visibility
    * @return collection of Weapons
    */
    ArrayList<Weapon> getWeapons () {
        return (weapons);
    }
    
    /**
    * @brief It trys to mount the booster with the index i inside the hangar. If 
    * a hangar is available, it removes the booster located in that position 
    * and if this operation is successful, it is added to the collection of
    * boosters in use.
    * @param i index
    */
    void mountShieldBooster (int i) {
        ShieldBooster aux;
        aux = hangar.removeShieldBooster(i);
        shieldBoosters.add(aux);
    }
    
    /**
    * @brief It trys to mount the weapon with the index i inside the hangar. If 
    * a hangar is available, it removes the weapon located in that position 
    * and if this operation is successful, it is added to the collection of
    * weapons in use.
    * @param i index
    */
    void mountWeapon (int i) {
        Weapon aux;
        aux = hangar.removeWeapon(i);
        weapons.add(aux);
    }
    
    /**
    * @brief builds a new WeaponToUI object from *this
    * @return WeaponToUI
    */
    void move () {
        
    }
    
    /**
    * @brief builds a new WeaponToUI object from *this
    * @return WeaponToUI
    */
    float protection () {
        
    }
    
    /**
    * @brief builds a new WeaponToUI object from *this
    * @return WeaponToUI
    */
    void receiveHagar (Hangar h) {
        
    }
    
    /**
    * @brief builds a new WeaponToUI object from *this
    * @return WeaponToUI
    */
    boolean receiveShieldBooster (ShieldBooster s) {
        
    }
    
    /**
    * @brief builds a new WeaponToUI object from *this
    * @return WeaponToUI
    */
    ShotResult receiveShot (float shot) {
        
    }
    
    /**
    * @brief builds a new WeaponToUI object from *this
    * @return WeaponToUI
    */
    void receiveSupplies (SuppliesPackage s) {
        
    }
    
    /**
    * @brief builds a new WeaponToUI object from *this
    * @return WeaponToUI
    */
    boolean receiveWeapon (Weapon w) {
        
    }
    
    /**
    * @brief builds a new WeaponToUI object from *this
    * @return WeaponToUI
    */
    void setLoot (Loot loot) {
        
    }
    
    /**
    * @brief builds a new WeaponToUI object from *this
    * @return WeaponToUI
    */
    void setPendingDamage (Damage d) {
        
    }
    
    /**
    * @brief builds a new WeaponToUI object from *this
    * @return WeaponToUI
    */
    boolean validState () {
        
    }
    
    
    
    
    
    
    
}
