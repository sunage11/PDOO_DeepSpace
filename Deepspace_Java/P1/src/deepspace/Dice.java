/**
 * @author BOLÍVAR PELÁEZ, CLARA
 * @author RUIZ GÓMEZ, SOLEDAD
 * 2º DGIIM - PDOO - Practice 1 DeepSpace
 */
package deepspace;
import java.util.Random;


/**
 * @title Dice
 * @brief It takes all random decisions in the game, based on a set of probabilities
 */
public class Dice {
    
    private final float  NHANGARSPROB;
    private final float  NSHIELDSPROB;
    private final float  NWEAPONSPROB;
    private final float  FIRSTSHOTPROB;
   
    private Random generator;
    
    /**
    * @brief Constructor
    */
    Dice () {
        NHANGARSPROB = 0.25f;
        NSHIELDSPROB = 0.25f;
        NWEAPONSPROB = 0.33f;
        FIRSTSHOTPROB = 0.5f;
        
        generator = new Random(); 
    }
    
    /**
    * @brief Determines how many hangars a spacial station will receive 
    * @returns 0 or 1 depending on NHANGARSPROB
    */
    int initWithNHangars() {
        
        if (generator.nextDouble() < NHANGARSPROB)
            return 0;
        else
            return 1;   
    }
    
    /**
    * @brief Determines how many weapons a spacial station will receive 
    * @returns 1, 2 or 3 depending on NWEAPONSPROB
    */
    int initWithNWeapons() {
        
        double probability = generator.nextDouble();
        
        if (probability < NWEAPONSPROB)
            return 1;
        else if (probability < 2*NWEAPONSPROB)
            return 2;
        else
            return 3;
        
    }
    
    /**
    * @brief Determines how many shield boosters a spacial station will receive 
    * @returns 0 or 1 depending on NSHIELDSPROB
    */
    int initWithNShields() {
        
        if (generator.nextDouble() < NSHIELDSPROB)
            return 0;
        else
            return 1;        
    }
    
    /**
    * @brief Determines the player who shall start playing
    * @returns index of the player
    */
    int whoStarts (int nPlayers) {
        
        return generator.nextInt(nPlayers); // returns a random integer between
                                            // 0 and nPlayers-1                                         
    }
    
    /**
    * @brief Determines whether a spacial station or an enemy starship starts
    * shooting when a combat takes place. It uses FIRSTSHOTPROB to determine this
    * @returns SPACESTATION or ENEMYSTARSHIP
    */
    GameCharacter firstShot () {
        
        if (generator.nextDouble() < FIRSTSHOTPROB)
            return GameCharacter.SPACESTATION;
        else
            return GameCharacter.ENEMYSTARSHIP;                                         
    }
    
    /**
    * @brief Determines whether a spacial station will escape to avoid a shot or
    * not. The probability of this move will be greater as the spacial station's 
    * potential speed is.
    * @returns true or false
    */
    boolean spaceStationMoves (float speed) {
        
        if (generator.nextDouble() < speed)
            return true;
        else
            return false;                                         
    }
       
 
}
