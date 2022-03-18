/**
 * @author BOLÍVAR PELÁEZ, CLARA
 * @author RUIZ GÓMEZ, SOLEDAD
 * 2º DGIIM - PDOO - Practice 1 DeepSpace
 */
package deepspace;
import java.util.ArrayList;

/**
 * @title Damage
 * @brief It represents the damage that an enemy starship makes to a
 * spacial station when it loses a combat
 */
public class Damage {
    
    private int nShields;
    private int nWeapons;
    private ArrayList<WeaponType> weapons;
    
    
    /**
    * @brief nWeapons constructor
    */
    protected Damage (int w, int s) {
        this.nWeapons = w;
        this.nShields = s;
        this.weapons=new ArrayList<>(); 
    }
    
    /**
    * @brief WeaponType constructor
    */
    protected Damage (WeaponType[] w, int s) {
        this.weapons=new ArrayList<WeaponType>(w);
        this.nShields = s;
        this.nWeapons = weapons.size();        
    }
    
    /**
    * @brief Copy constructor
    * @param d another Damage instance
    */
    protected Damage (Damage d) {
              
    }
    
    /**
    * @brief builds a new DamageToUI object from *this
    * @return DamageToUI
    */
    protected DamageToUI getUIVersion (Damage d) {
              
    }
    
    /**
    * @brief builds a new DamageToUI object from *this
    * @return DamageToUI
    */
    private int arrayContainsType (Weapon[] w, WeaponType t) {
        
              
    }
    
    /**
    * @brief builds a new DamageToUI object from *this
    * @return DamageToUI
    */
    Damage adjust (Weapon[] w, ShieldBooster[] sb) {
              
    }
    
    /**
    * @brief builds a new DamageToUI object from *this
    * @return DamageToUI
    */
    void discardWeapon (Weapon w) {
              
    }
    
    /**
    * @brief builds a new DamageToUI object from *this
    * @return DamageToUI
    */
    void discardShieldBooster () {
              
    }
    
    /**
    * @brief builds a new DamageToUI object from *this
    * @return DamageToUI
    */
    boolean hasNoEffect () {
              
    }
    
    /**
    * @brief builds a new DamageToUI object from *this
    * @return DamageToUI
    */
    int getNShields () {
              
    }
    
    /**
    * @brief builds a new DamageToUI object from *this
    * @return DamageToUI
    */
    int getNWeapons () {
              
    }
    
    /**
    * @brief builds a new DamageToUI object from *this
    * @return DamageToUI
    */
    WeaponType [] getWeapons() {
              
    }
    
    
    
    
    
    
}
