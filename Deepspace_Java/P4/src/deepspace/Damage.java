/**
 * @author BOLÍVAR PELÁEZ, CLARA
 * @author RUIZ GÓMEZ, SOLEDAD
 * 2º DGIIM - PDOO - Practice 1 DeepSpace
 */
package deepspace;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @title Damage
 * @brief It represents the damage that an enemy starship makes to a
 * spacial station when it loses a combat
 */
abstract class Damage {
    
    private int nShields;
    
    
    /**
    * @brief nWeapons constructor -> numeric damage
    */
    Damage (int s) {
        this.nShields = s;
    }
    
    public abstract Damage copy();
    
    
    /**
    * @brief builds a new DamageToUI object from *this
    * @return DamageToUI
    */
    DamageToUI getUIversion () {
        return new DamageToUI (this);
    }
    
    
    
    /**
    * @brief returns a an adjusted version of *this. It takes into consideration
    * the parameters w ans sb in order to modify the output value so it does not
    * imply losing weapons or shields that are nos specified in w or sb
    * @param w ArrayList of weapons
    * @param sb ArrayList of shield boosters
    * @return modifies version of *this
    */
     public abstract Damage adjust (ArrayList<Weapon> w, ArrayList<ShieldBooster> sb);
    
    /**
    * @brief If *this has w.getType() in the array weapons, it deletes that element
    * of the array. In other case, it decrements nWeapons in one unit
    * @param w weapon which type is to be deleted
    * @return void
    */
    public abstract void discardWeapon (Weapon w);
    
    /**
    * @brief it decrements nShields in one unit
    * @return void
    */
    void discardShieldBooster () {
        if (nShields > 0)
            nShields--;
    }
    
    /**
    * @brief returns true if *this does not imply any accessory loss
    * @return true if *this damage has no effect
    */
    boolean hasNoEffect () {
        return ((nWeapons==0) && (nShields==0) && (weapons.isEmpty()));
    }
    
    /**
    * @brief builds a new DamageToUI object from *this
    * @return DamageToUI
    */
    int getNShields () {
       return nShields;
    }
    
    /**
    * @brief builds a new DamageToUI object from *this
    * @return DamageToUI
    */
    int getNWeapons () {
      return nWeapons;        
    }
    
    /**
    * @brief builds a new DamageToUI object from *this
    * @return DamageToUI
    */
    ArrayList<WeaponType> getWeapons() {
        ArrayList<WeaponType> output = new ArrayList<>(weapons);
        return output;
    }
    
    
    /**
    * @brief toString
    * @return String with info about the instance
    */
    public String toString () {
        
        String output = "Damage [ nShields " + nShields 
                        + " ; nWeapons " + nWeapons
                        + " ; weapons " + weapons.toString() + " ]";
        
        return output;
    }
  
}
