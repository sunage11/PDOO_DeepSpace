/**
 * @author BOLÍVAR PELÁEZ, CLARA
 * @author RUIZ GÓMEZ, SOLEDAD
 * 2º DGIIM - PDOO - Practice 1 DeepSpace
 */
package deepspace;

/**
 * @title SuppliesPackage
 * @brief It represents a spacial station's supplies
 */
public class SuppliesPackage {
    
    private float ammoPower;
    private float fuelUnits;
    private float shieldPower;
    
    /**
    * @brief Constructor
    */
    SuppliesPackage (float a, float f, float s) {
        ammoPower   = a;
        fuelUnits   = f;
        shieldPower = s;
    }
    
    /**
    * @brief Copy constructor
    */
    SuppliesPackage (SuppliesPackage s) {
        ammoPower   = s.ammoPower;
        fuelUnits   = s.fuelUnits;
        shieldPower = s.shieldPower;
    }
    
    /**
    * @brief Getter with package visibility
    * @return ammoPower value
    */
    float getAmmoPower () {
        return ammoPower;
    }
    
    /**
    * @brief Getter with package visibility
    * @return fuelUnits value
    */
    float getFuelUnits () {
        return fuelUnits;
    }
    
    /**
    * @brief Getter with package visibility
    * @return shieldPower value
    */
    float getShieldPower () {
        return shieldPower;
    }
    
    /**
    * @brief toString
    * @return String with info about the instance
    */
    @Override
    public String toString () {
        
        String output = "SuppliesPackage [ ammoPower " + ammoPower 
                        + " ; fuelUnits " + fuelUnits 
                        +  " ; shieldPower " + shieldPower +" ]";
        
        return output;
    }
    
 
}
