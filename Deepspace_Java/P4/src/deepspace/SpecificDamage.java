/**
 * @author BOLÍVAR PELÁEZ, CLARA
 * @author RUIZ GÓMEZ, SOLEDAD
 * 2º DGIIM - PDOO - Practice 1 DeepSpace
 */
package deepspace;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @title SpecificDamage
 * @brief It represents the damage that an enemy starship makes to a
 * spacial station when it loses a combat
 */
public class SpecificDamage extends Damage{
    
    private ArrayList<WeaponType> weapons;
    
    /**
    * @brief WeaponType constructor -> specific damage
    */
    SpecificDamage (ArrayList<WeaponType> w, int s) {
        super(s);
        if (w != null)
            this.weapons = new ArrayList<>(w);
        else
            this.weapons = new ArrayList<>();
    }
    
    /**
    * @brief Copy 
    * @return a copy of the instance
    */
    @Override
    public SpecificDamage copy() {
        return new SpecificDamage(weapons, getNShields());
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
    @Override
    public SpecificDamage adjust (ArrayList<Weapon> w, ArrayList<ShieldBooster> sb) {
        
        int shields = Integer.min(getNShields(), sb.size());
        
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

        SpecificDamage output = new SpecificDamage (aux, shields);
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
         if(!weapons.isEmpty()){
            weapons.remove(w.getType());
        }  
    }
    
    /**
    * @brief returns true if *this does not imply any accessory loss
    * @return true if *this damage has no effect
    */
    @Override
    public boolean hasNoEffect () {
        return ((getNShields()==0) && (weapons.isEmpty()));
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
        
        String output = "Damage [ nShields " + getNShields() 
                        + " ; weapons " + weapons.toString() + " ]";
        
        return output;
    }
    
    
    
    @Override
    SpecificDamageToUI getUIversion(){
        return new SpecificDamageToUI(this);
    }
}
