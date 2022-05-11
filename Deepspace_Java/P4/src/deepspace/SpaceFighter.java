/**
 * @author BOLÍVAR PELÁEZ, CLARA
 * @author RUIZ GÓMEZ, SOLEDAD
 * 2º DGIIM - PDOO - Practice 4 DeepSpace
 */
package deepspace;

/**
 * INTERFAZ SPACE FIGHTER
 * @author clara
 */
public interface SpaceFighter {
    
    // Shoots
    public float fire();
    
    // Protects
    public float protection();
    
    // Receives shot
    public ShotResult receiveShot (float shot); 
    
}
