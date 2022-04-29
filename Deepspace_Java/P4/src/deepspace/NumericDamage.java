
package deepspace;

import java.util.ArrayList;

/**
 *
 * @author clara
 */
public class NumericDamage extends Damage {
    
    private int nWeapons;
    
    NumericDamage(int nw, int s){
        super(s);
        this.nWeapons=nw; 
    }
    
    @Override
    public NumericDamage copy(){
        return new NumericDamage(nWeapons, getNShields());
    }
    
    @Override
    public NumericDamage adjust (ArrayList<Weapon> w, ArrayList<ShieldBooster> sb) {
        
        int shields = Integer.min(getNShields(), sb.size());

        NumericDamage output = new NumericDamage (Integer.min (nWeapons, w.size()), shields);
        return output;
   
    }
    
   @Override
    public void discardWeapon (Weapon w) {
        if (nWeapons > 0)
            nWeapons--;     
    }
           
    
    
    
    
}
