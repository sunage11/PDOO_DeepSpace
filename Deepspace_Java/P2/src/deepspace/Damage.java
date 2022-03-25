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
    * @brief nWeapons constructor
    */
    protected Damage (int w, int s) {
        this.nWeapons = w;
        this.nShields = s;
        this.weapons=new ArrayList<>(); 
    }
    
    /**
    * @brief WeaponType constructor
    */
    protected Damage (ArrayList<WeaponType> w, int s) {
        this.weapons=new ArrayList<WeaponType>(w);
        this.nShields = s;
        this.nWeapons = weapons.size();        
    }
    
    /**
    * @brief Copy constructor
    * @param d another Damage instance
    */
    protected Damage (Damage d) {
        this.nWeapons = d.nWeapons;
        this.nShields = d.nShields;
        this.weapons = new ArrayList<WeaponType>(d.weapons);         
    }
    
    /**
    * @brief builds a new DamageToUI object from *this
    * @return DamageToUI
    */
    protected DamageToUI getUIVersion () {
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
    * @brief builds a new DamageToUI object from *this
    * @return DamageToUI
    */
    Damage adjust (ArrayList<Weapon> w, ArrayList<ShieldBooster> sb) {
        
        int shields = Integer.min(nShields, sb.size());
        
        if (weapons == null) {
            Damage output = new Damage (Integer.min (nWeapons, w.size()), shields);
            return output;
        } // if we do not have weapons in the array
        
        ArrayList<Weapon> aux = new ArrayList <Weapon> (w);
        ArrayList<WeaponType> aux2 = new ArrayList<> ();
        int i;
        
        for (WeaponType element: weapons) {
            i = arrayContainsType (aux, element);
        // so we see the weapon types in the array
        
            if (i!=-1) { //if the type is found, we delete it
                aux2.add(element);
                aux.remove(i);
            }
        }
        
        Damage output = new Damage (aux2, shields);
        return output;
        
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
              // DUDA
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
        return weapons;
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
