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

    
    /**
    * @brief Copy constructor
    * @param d another Damage instance
    */
    public abstract Damage copy();
    
    /**
    * @brief builds a new DamageToUI object from *this
    * @return DamageToUI
    */
    abstract DamageToUI getUIversion ();
    

    
    /**
    * @brief returns a an adjusted version of *this. It takes into consideration
    * the parameters w ans sb in order to modify the output value so it does not
    * imply losing weapons or shields that are nos specified in w or sb
    * @param w ArrayList of weapons
    * @param sb ArrayList of shield boosters
    * @return modifies version of *this
    */
     public int adjust (ArrayList<ShieldBooster> sb) {
         return Integer.min(getNShields(), sb.size());
     }
    
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
    public boolean hasNoEffect () {
        return nShields==0;
    }
    
    /**
    * @brief builds a new DamageToUI object from *this
    * @return DamageToUI
    */
    int getNShields () {
       return nShields;
    }
    
    
    /**
    * @brief toString
    * @return String with info about the instance
    */
    public abstract String toString ();
  
}
