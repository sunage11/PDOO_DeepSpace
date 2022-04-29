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
public class Damage {
    
    private int nShields;
    private int nWeapons;
    private ArrayList<WeaponType> weapons;
    
    
    /**
    * @brief nWeapons constructor -> numeric damage
    */
    Damage (int w, int s) {
        this.nWeapons = w;
        this.nShields = s;
        this.weapons = new ArrayList<>(); 
    }
    
    /**
    * @brief WeaponType constructor -> specific damage
    */
    Damage (ArrayList<WeaponType> w, int s) {
        this.weapons = new ArrayList<WeaponType>(w);
        this.nShields = s;
        this.nWeapons = -1;        
    }
    
    /**
    * @brief Copy constructor
    * @param d another Damage instance
    */
    Damage (Damage d) {
        this.nWeapons = d.nWeapons;
        this.nShields = d.nShields;
        this.weapons = new ArrayList<>(d.weapons);         
    }
    
    /**
    * @brief builds a new DamageToUI object from *this
    * @return DamageToUI
    */
    DamageToUI getUIversion () {
        return new DamageToUI (this);
    }
    
    /**
    * @brief builds a new DamageToUI object from *this
    * @return DamageToUI
    */
    private int arrayContainsType (ArrayList <Weapon> w, WeaponType t) {
        
        Iterator<Weapon> it =w.iterator();
        int pos=0;
        
        while(it.hasNext()){
            Weapon aux = it.next();
            
            if(aux.getType() == t)
                return pos;
            else
                pos++;
        }
        
        return -1;
            
            
    }
    
    /**
    * @brief returns a an adjusted version of *this. It takes into consideration
    * the parameters w ans sb in order to modify the output value so it does not
    * imply losing weapons or shields that are nos specified in w or sb
    * @param w ArrayList of weapons
    * @param sb ArrayList of shield boosters
    * @return modifies version of *this
    */
     Damage adjust (ArrayList<Weapon> w, ArrayList<ShieldBooster> sb) {
        
        int shields = Integer.min(nShields, sb.size());

        // If it is numeric damage
        if (nWeapons != -1) {
            Damage output = new Damage (Integer.min (nWeapons, w.size()), shields);
            return output;
        // If it is specific damage
        } else {  
            ArrayList<WeaponType> aux = new ArrayList <> ();
            ArrayList<Weapon> aux2 = new ArrayList <> (w);
            
            for (WeaponType element: weapons) { // going through *this
                // checking if each type is contained in the param
                int i = arrayContainsType (aux2, element);
                if (i != -1) {
                    aux2.remove(i);
                    aux.add(element);
                }
            }
            
            Damage output = new Damage (aux, shields);
            return output;
        }
        
    }
    
    /**
    * @brief If *this has w.getType() in the array weapons, it deletes that element
    * of the array. In other case, it decrements nWeapons in one unit
    * @param w weapon which type is to be deleted
    * @return void
    */
    void discardWeapon (Weapon w) {
        if (!weapons.remove(w.getType()))
            if (nWeapons > 0)
                nWeapons--;     
    }
    
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
