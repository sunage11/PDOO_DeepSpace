/**
 * @author BOLÍVAR PELÁEZ, CLARA
 * @author RUIZ GÓMEZ, SOLEDAD
 * 2º DGIIM - PDOO - Practice 4 DeepSpace
 */
package deepspace;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author clara
 */
public class SpaceCity extends SpaceStation {
    
    private SpaceStation base;
    private ArrayList<SpaceStation> collaborators;
    
    public SpaceCity (SpaceStation b, ArrayList<SpaceStation> c) {
        super(b);
        base = b;
        collaborators = new ArrayList<> (c);
    }
    
    
    public ArrayList<SpaceStation> getCollaborators() {
        return collaborators;
    }
    
    @Override
    public float fire () {
        
        float output = 0;
        output += base.fire();
        
        Iterator<SpaceStation> it = collaborators.iterator();
         
        while (it.hasNext()) {
            output += it.next().fire();
        }
        
        return output;
    }
    
    @Override
    public float protection () {
        
        float output = 0;
        output += base.protection();
        
        Iterator<SpaceStation> it = collaborators.iterator();
         
        while (it.hasNext()) {
            output += it.next().protection();
        }
        
        return output;
    
    }
    
    @Override
    public Transformation setLoot (Loot loot) {
    
        super.setLoot(loot);
        return Transformation.NOTRANSFORM;
        // Se hacen los mismos cálculos (no copiamos código) pero nunca se 
        // transforma la Space<city porque ya no puede más, así que siempre
        // returneamos NOTRANSFORM
    }
    
    /**
    * @brief builds a new SpaceCityToUI object from *this
    * @return WeaponToUI
    */
    @Override
    SpaceCityToUI getUIversion () {
        return new SpaceCityToUI (this);
    }
    
    /**
     * @brief toString
    * @return String with info about the instance
    */
     /*@Override
    public String toString () {
        
        String output = super.toString();
        output += "\n Los colaboradores son: \n";
        
        int size = collaborators.size();
        for(int i=0; i< size; i++)
            output += collaborators[i].toString();
            
        
        return output;
    }*/
    
  }
