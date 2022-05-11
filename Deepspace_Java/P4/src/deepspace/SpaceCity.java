/**
 * @author BOLÍVAR PELÁEZ, CLARA
 * @author RUIZ GÓMEZ, SOLEDAD
 * 2º DGIIM - PDOO - Practice 4 DeepSpace
 */
package deepspace;

import java.util.ArrayList;

/**
 *
 * @author clara
 */
public class SpaceCity extends SpaceStation {
    
    private SpaceStation base;
    private ArrayList<SpaceStation> collaborators;
    
    SpaceCity (SpaceStation b, ArrayList<SpaceStation> c) {
        super(b);
        base = b;
        collaborators = new ArrayList<> (c);
    }
    
    
  }
    
}
