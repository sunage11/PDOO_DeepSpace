/**
 * @author BOLÍVAR PELÁEZ, CLARA
 * @author RUIZ GÓMEZ, SOLEDAD
 * 2º DGIIM - PDOO - Practice 2 DeepSpace
 */
package deepspace;

/**
 *
 * @author sunage
 */
public class SpaceStation {
    
    private final int MAXFUEL = 100;
    private final int SHIELDLOSSPERUNITSHOT = 100;
    
    private float ammoPower;
    private float fuelUnits;
    private String name;
    private int nMedals;
    private float shieldPower;
    private Damage pendingDamage;
    
    
    /**
    * @brief Copy constructor
    * @param d another Damage instance
    */
    void assignFuelValue (float f) {
        
    }
    
    /**
    * @brief Copy constructor
    * @param d another Damage instance
    */
    void cleanPendingDamage () {
        
    }
    
    /**
    * @brief Copy constructor
    * @param d another Damage instance
    */
    protected SpaceStation (String n, SuppliesPackage supplies) {
        
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
    * @brief Copy constructor
    * @param d another Damage instance
    */
    float getAmmoPower () {
        
    }
    
    /**
    * @brief Copy constructor
    * @param d another Damage instance
    */
    float getFuelUnits () {
        
    }
    
    /**
    * @brief Copy constructor
    * @param d another Damage instance
    */
    Hangar getHangar () {
        
    }
    
    /**
    * @brief Copy constructor
    * @param d another Damage instance
    */
    String getName () {
        
    }
    
    /**
    * @brief Copy constructor
    * @param d another Damage instance
    */
    int getNMedals () {
        
    }
    
    /**
    * @brief Copy constructor
    * @param d another Damage instance
    */
    Damage getPendingDamage () {
        
    }
    
    /**
    * @brief Copy constructor
    * @param d another Damage instance
    */
    ShieldBooster[] getShieldBooster () {
        
    }
    
    /**
    * @brief Copy constructor
    * @param d another Damage instance
    */
    float getShieldPower () {
        
    }
    
    /**
    * @brief Copy constructor
    * @param d another Damage instance
    */
    float getPower () {
        
    }
    
    /**
    * @brief Copy constructor
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
