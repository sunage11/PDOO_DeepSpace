/**
 * @author BOLÍVAR PELÁEZ, CLARA
 * @author RUIZ GÓMEZ, SOLEDAD
 * 2º DGIIM - PDOO - Practice 2 DeepSpace
 */
package deepspace;

import java.util.ArrayList;

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
    * @brief Copy constructor
    * @param d another Damage instance
    */
    void cleanUpMountedItems () {
        
    }
    
    /**
    * @brief Copy constructor
    * @param d another Damage instance
    */
    void discardHangar () {
        
    }
    
    /**
    * @brief Copy constructor
    * @param d another Damage instance
    */
    void discardShieldBooster (int i) {
        
    }
    
    /**
    * @brief Copy constructor
    * @param d another Damage instance
    */
    void discardShieldBoosterInHangar (int i) {
        
    }
    
    /**
    * @brief Copy constructor
    * @param d another Damage instance
    */
    void discardWeapon (int i) {
        
    }
    
    /**
    * @brief Copy constructor
    * @param d another Damage instance
    */
    void discardWeaponInHangar (int i) {
        
    }
    
    /**
    * @brief Copy constructor
    * @param d another Damage instance
    */
    float fire () {
        
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
    * @return hangar instance
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
    * @param d another Damage instance
    */
    int getNMedals () {
        
    }
    
    /**
    * @brief Getter with package visibility
    * @param d another Damage instance
    */
    Damage getPendingDamage () {
        
    }
    
    /**
    * @brief Getter with package visibility
    * @param d another Damage instance
    */
    ShieldBooster[] getShieldBooster () {
        
    }
    
    /**
    * @brief Getter with package visibility
    * @param d another Damage instance
    */
    float getShieldPower () {
        
    }
    
    /**
    * @brief Getter with package visibility
    * @param d another Damage instance
    */
    float getPower () {
        
    }
    
    /**
    * @brief Getter with package visibility
    * @param d another Damage instance
    */
    float getSpeed () {
        
    }
    
    /**
    * @brief builds a new WeaponToUI object from *this
    * @return WeaponToUI
    */
    SpaceStationToUI getUIversion () {
        return new SpaceStationToUI (this);
    }
    
    /**
    * @brief builds a new WeaponToUI object from *this
    * @return WeaponToUI
    */
    Weapon[] getWeapons () {
        
    }
    
    /**
    * @brief builds a new WeaponToUI object from *this
    * @return WeaponToUI
    */
    void mountShieldBooster (int i) {
        
    }
    
    /**
    * @brief builds a new WeaponToUI object from *this
    * @return WeaponToUI
    */
    void mountWeapons (int i) {
        
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
    * @brief calculates the adjusted damage from param d to the weapon and shield
    * collections in *this and then saves it in pendingDamage
    * @return WeaponToUI
    */
    void setPendingDamage (Damage d) {
        pendingDamage = d.adjust(weapons, shieldBoosters)
    }
    
    /**
    * @brief returns true if *this is in a valid state (this implies not to have
    * any pendingDamage at all or with any effect
    * @return true if *this is in a valid state, false otherwise
    */
    boolean validState () {
        return ((pendingDamage == null) || (pendingDamage.hasNoEffect()));
    }
    
    
    
    
    
    
    
}
