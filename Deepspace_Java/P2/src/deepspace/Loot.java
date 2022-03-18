/**
 * @author BOLÍVAR PELÁEZ, CLARA
 * @author RUIZ GÓMEZ, SOLEDAD
 * 2º DGIIM - PDOO - Practice 1 DeepSpace
 */
package deepspace;

/**
 * @title Loot
 * @brief It represents the loot that a station can get if it beats an enemy starship
 */
public class Loot {
    
    private int nSupplies;
    private int nWeapons;
    private int nShields;
    private int nHangars;
    private int nMedals;
    
    
    /**
    * @brief Constructor
    */
    Loot (int s, int w, int sh, int h, int m) {
        this.nSupplies = s;
        this.nWeapons  = w;
        this.nShields  = sh;
        this.nHangars  = h;
        this.nMedals   = m;
    }
    
    /**
    * @brief Getter with package visibility
    * @return nSupplies value
    */
    int getNSupplies () {
        return nSupplies;
    }
    
    /**
    * @brief Getter with package visibility
    * @return nWeapons value
    */
    int getNWeapons () {
        return nWeapons;
    }
    
    /**
    * @brief Getter with package visibility
    * @return nShields value
    */
    int getNShields () {
        return nShields;
    }
    
    /**
    * @brief Getter with package visibility
    * @return nHangars value
    */
    int getNHangars () {
        return nHangars;
    }
    
    /**
    * @brief Getter with package visibility
    * @return nMedals value
    */
    int getNMedals () {
        return nMedals;
    }
    
    /**
    * @brief toString
    * @return String with info about the instance
    */
    public String toString () {
        
        String output = "Loot [ nSupplies " + nSupplies 
                        + " ; nWeapons " + nWeapons 
                        + " ; nShields " + nShields 
                        + " ; nHangars " + nHangars 
                        + " ; nMedals " + nMedals + " ]";
        
        return output;
    }
 
}
