/**
 * @author BOLÍVAR PELÁEZ, CLARA
 * @author RUIZ GÓMEZ, SOLEDAD
 * 2º DGIIM - PDOO - Practice 1 DeepSpace
 */
package deepspace;
import java.util.ArrayList;

/**
 * @title Hangar
 * @brief 
 */
public class Hangar {
    private int maxElements;
    private ArrayList<ShieldBooster> shieldBoosters;
    private ArrayList<Weapon> weapons;
    
    
    /**
    * @brief Constructor
    */
    protected Hangar (int capacity){
        throw new UnsupportedOperationException();
    }
    
    /**
    * @brief Copy constructor
    */
    protected Hangar (Hangar h){
        throw new UnsupportedOperationException();
    }
    
    /**
    * @brief builds a new HangarToUI object from *this
    * @return HangarToUI
    */
    protected HangarToUI getUIversion(){
        return new HangarToUI (this);
    }
    
    
    /**
    * @brief It returns true if elements can be added. 
    * @return true if there is empty space to add elements, false in other case
    */
    private boolean spaceAvailable(){
        int currentElements = shieldBoosters.size() + weapons.size();
        return (maxElements > currentElements);
    }
    
    /**
    * @brief  
    * @return 
    */
    boolean addWeapon (Weapon w){
        
    }
    
    /**
    * @brief  
    * @return 
    */
    boolean addShieldBooster (ShieldBooster s){
        
    }
    
    /**
    * @brief  Getter with package visibility
    * @return maxElements value
    */
    int getMaxElements(){
        return(maxElements);
    }
    
    /**
    * @brief  
    * @return 
    */
    ShieldBooster[] getShieldBoosters(){
        
    }
    
    /**
    * @brief  Getter with package visibility
    * @return weapons objects
    */
    Weapon[] getWeapons(){
        return weapons;
    }
    
    /**
    * @brief  
    * @return 
    */
    ShieldBooster removeShieldBooster (int s){
        
    }
    
    /**
    * @brief  
    * @return 
    */
    Weapon removeWeapon(int w){
        
    }
    
}
