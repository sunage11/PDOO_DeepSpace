
package deepspace;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author clara
 */
public class SpecificDamage extends Damage {
    
    private ArrayList<WeaponType> weapons;
    
    /**
    * @brief WeaponType constructor -> specific damage
    */
    SpecificDamage (ArrayList<WeaponType> w, int s) {
        super(s);
        if(w!=null)
            this.weapons = new ArrayList<>(w);    
        else
            this.weapons = new ArrayList<>(); 
            
    }
    
    @Override
    public SpecificDamage copy(){
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
        
    }

    

    @Override
    public void discardWeapon(Weapon w){
        if(weapons.isEmpty() == false){
            weapons.remove(w.getType());
        }
    }
    
}
