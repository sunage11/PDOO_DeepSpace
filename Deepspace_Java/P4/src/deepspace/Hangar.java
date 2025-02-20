/**
 * @author BOLÍVAR PELÁEZ, CLARA
 * @author RUIZ GÓMEZ, SOLEDAD
 * 2º DGIIM - PDOO - Practice 2 DeepSpace
 */
package deepspace;
import java.util.ArrayList;

/**
 * @title Hangar
 * @brief 
 */
public class Hangar{
    
    private int maxElements;
    private ArrayList<ShieldBooster> shieldBoosters;
    private ArrayList<Weapon> weapons;
    
    
    /**
    * @brief Constructor
    */
    Hangar (int capacity){
        maxElements=capacity;
        shieldBoosters= new ArrayList<>();
        weapons= new ArrayList<>();
    }
    
    /**
    * @brief Copy constructor
    */
    Hangar (Hangar h){
        
        maxElements = h.maxElements;
        shieldBoosters = new ArrayList <> (h.shieldBoosters);
        weapons = new ArrayList <> (h.weapons);
    }
    
    /**
    * @brief builds a new HangarToUI object from *this
    * @return HangarToUI
    */
    HangarToUI getUIversion(){
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
    * @brief  adds w to the weapons array if there is enough room for it
    * @param w weapon to add
    * @return true if it has been added or false otherwise
    */
    boolean addWeapon (Weapon w){
        if(spaceAvailable()){
            weapons.add(w);
            return true;
        }
        else
            return false;
    }
    
    /**
    * @brief  adds s to the shieldBoosters array if there is enough room for it
    * @param s shield booster to add
    * @return true if it has been added or false otherwise
    */
    boolean addShieldBooster (ShieldBooster s){
        if(spaceAvailable()){
            shieldBoosters.add(s);
            return true;
        }
        else
            return false;
    }
    
    /**
    * @brief  Getter with package visibility
    * @return maxElements value
    */
    int getMaxElements(){
        return(maxElements);
    }
    
    /**
    * @brief  Getter with package visibility
    * @return shield booster objects array 
    */
    ArrayList<ShieldBooster> getShieldBoosters(){
        ArrayList<ShieldBooster> output = new ArrayList<>(shieldBoosters);
        return output;
    }
    
    /**
    * @brief  Getter with package visibility
    * @return weapons objects array
    */
    ArrayList<Weapon> getWeapons(){
        ArrayList<Weapon> output = new ArrayList<>(weapons);
        return output;
    }
    
    /**
    * @brief Deletes the shield booster number s (if possible) and returns it. 
    * In other case, it returns null.
    * @param s The index of the shield booster to delete
    * @return The deleted shield booster
    */
    ShieldBooster removeShieldBooster (int s){
        
        if (s>=0 && shieldBoosters.size() > s) {
            return shieldBoosters.remove(s);
        } else {
            return null;
        }
        
    }
    
    /**
    * @brief Deletes the weapon number w (if possible) and returns it. In other 
    * case, it returns null.
    * @param w The index of the weapon to delete
    * @return The deleted weapon
    */
    Weapon removeWeapon(int w){
        
        if (w>=0 && weapons.size() > w) {
           return  weapons.remove(w);
        } else {
            return null;
        }
    }
    
    /**
    * @brief toString
    * @return String with info about the instance
    */
    @Override
    public String toString () {
        
        String output = "Hangar [ maxElements " + maxElements 
                        + " ; shieldBoosters " + shieldBoosters.toString()
                        + " ; weapons " + weapons.toString() + " ]";
        
        return output;
    }
    
}
