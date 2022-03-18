/**
 * @author BOLÍVAR PELÁEZ, CLARA
 * @author RUIZ GÓMEZ, SOLEDAD
 * 2º DGIIM - PDOO - Practice 1 DeepSpace
 */
package deepspace;

/**
 * @title ShieldBooster
 * @brief It represents a spacial station's shield booster
 */
public class ShieldBooster {
    
    private String name;
    private float  boost;
    private int    uses;
    
    /**
    * @brief Constructor
    */
    ShieldBooster (String n, float b, int u) {
        name    = n;
        boost   = b;
        uses    = u;
    }
    
    /**
    * @brief Copy constructor
    */
    ShieldBooster (ShieldBooster s) {
        name    = s.name;
        boost   = s.boost;
        uses    = s.uses;
    }
    
    
    /**
    * @brief Getter with package visibility
    * @return boost value
    */
    float getBoost () {
        return boost;
    }
    
    /**
    * @brief Getter with package visibility
    * @return uses value
    */
    int getUses () {
        return uses;
    }
    
    /**
    * @brief Decreases uses in one unit, returns boost if uses > 0
    * or 1.0 otherwise
    * @return boost value or 1.0
    */
    float useIt () {
        if (uses > 0) {
            uses--;
            return boost;
        } else {
            return 1.0f;
        }
    }
    
    /**
    * @brief builds a new WeaponToUI object from *this
    * @return WeaponToUI
    */
    protected ShieldToUI getUIVersion(){ //DUDAAAA protected
        return(new ShieldToUI(this));
    }
    
    /**
    * @brief toString
    * @return String with info about the instance
    */
    public String toString () {
        
        String output = "ShieldBooster [ name " + name 
                        + " ; boost " + boost 
                        + " ; uses " + uses + " ]";
        
        return output;
    }
    
    
 
}