/**
 * @author BOLÍVAR PELÁEZ, CLARA
 * @author RUIZ GÓMEZ, SOLEDAD
 * 2º DGIIM - PDOO - Practice 1 DeepSpace
 */
package deepspace;

/**
 * @title Weapon
 * @brief It represents a spacial station's weapons
 */
public class Weapon {
    
    private String      name;
    private WeaponType  type;
    private int         uses;
    
    /**
    * @brief Constructor
    */
    Weapon (String n, WeaponType t, int u) {
        name    = n;
        type    = t;
        uses    = u;
    }
    
    /**
    * @brief Copy constructor
    */
    Weapon (Weapon w) {
        name    = w.name;
        type    = w.type;
        uses    = w.uses;
    }
    
    
    /**
    * @brief Getter with package visibility
    * @return type value
    */
    WeaponType getType () {
        return type;
    }
    
    /**
    * @brief Getter with package visibility
    * @return uses value
    */
    int getUses () {
        return uses;
    }
    
    /**
    * @brief Returns the weapon power
    * @return type.getPower()
    */
    float power () {
        return type.getPower();
    }
    
    /**
    * @brief Decreases uses in one unit, returns power() if uses > 0
    * or 1.0 otherwise
    * @return boost value or 1.0
    */
    float useIt () {
        if (uses > 0) {
            uses--;
            return this.power();
        } else {
            return 1.0f;
        }
    }
    
    /**
    * @brief builds a new WeaponToUI object from *this
    * @return WeaponToUI
    */
    protected WeaponToUI getUIVersion () { //DUDAAAA protected
        
        return new WeaponToUI (this);
    }

    
    /**
    * @brief toString
    * @return String with info about the instance
    */
    public String toString () {
        
        String output = "Weapon [ name " + name 
                        + " ; WeaponType " + type 
                        + " ; uses " + uses + " ]";
        
        return output;
    }
    
}
    

