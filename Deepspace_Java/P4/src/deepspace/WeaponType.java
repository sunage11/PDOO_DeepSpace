/**
 * @author BOLÍVAR PELÁEZ, CLARA
 * @author RUIZ GÓMEZ, SOLEDAD
 * 2º DGIIM - PDOO - Practice 1 DeepSpace
 */
package deepspace;

/**
 * @title WeaponType
 * @brief It represents the types of weapons
 */
public enum WeaponType { 
    
    LASER(2.0f), MISSILE(3.0f), PLASMA(4.0f); 
    
    private float power; //DUDAAAAAAAAAAAAAAAAAAAA
    
    /**
    * @brief Constructor
    */
    WeaponType (float p) {
        this.power = p;
    }
    
    /**
    * @brief Getter with package visibility
    * @return power value
    */
    float getPower () {
        return power;
    }

}

