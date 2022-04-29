/**
 * @author BOLÍVAR PELÁEZ, CLARA
 * @author RUIZ GÓMEZ, SOLEDAD
 * 2º DGIIM - PDOO - Practice 1 DeepSpace
 */
package deepspace;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @title NumericDamage
 * @brief It represents the damage that an enemy starship makes to a
 * spacial station when it loses a combat
 */
public class NumericDamage extends Damage{
    
    private int nWeapons;
    
    /**
    * @brief WeaponType constructor -> specific damage
    */
    NumericDamage (int w, int s) {
        super(s);
        this.nWeapons = w;
    }
    
    /**
    * @brief Copy 
    * @return a copy of the instance
    */
    @Override
    public NumericDamage copy() {
        return new NumericDamage(nWeapons, getNShields());
    }
    
    /**
    * @brief returns a an adjusted version of *this. It takes into consideration
    * the parameters w ans sb in order to modify the output value so it does not
    * imply losing weapons or shields that are nos specified in w or sb
    * @param w ArrayList of weapons
    * @param sb ArrayList of shield boosters
    * @return modifies version of *this
    */
    @Override
    public NumericDamage adjust (ArrayList<Weapon> w, ArrayList<ShieldBooster> sb) {
        int shields = Integer.min(getNShields(), sb.size());
        NumericDamage output = new NumericDamage (Integer.min (nWeapons, w.size()), shields);
        return output;
        
    }
    
    
    /**
    * @brief If *this has w.getType() in the array weapons, it deletes that element
    * of the array. In other case, it decrements nWeapons in one unit
    * @param w weapon which type is to be deleted
    * @return void
    */
    @Override
    public void discardWeapon (Weapon w) {
        if (nWeapons > 0)
                nWeapons--;   
    }
    
    /**
    * @brief returns true if *this does not imply any accessory loss
    * @return true if *this damage has no effect
    */
    @Override
    public boolean hasNoEffect () {
        return ((nWeapons==0) && (getNShields()==0));
    }
    
    /**
    * @brief builds a new DamageToUI object from *this
    * @return DamageToUI
    */
    int getNWeapons () {
      return nWeapons;        
    }
    
    /**
    * @brief toString
    * @return String with info about the instance
    */
    public String toString () {
        
        String output = "Damage [ nShields " + getNShields() 
                        + " ; nWeapons " + nWeapons + " ]";
        
        return output;
    }
    
    @Override
    NumericDamageToUI getUIversion(){
        return new NumericDamageToUI(this);
    }
    
}
