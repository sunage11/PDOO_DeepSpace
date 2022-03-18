/**
 * @author BOLÍVAR PELÁEZ, CLARA
 * @author RUIZ GÓMEZ, SOLEDAD
 * 2º DGIIM - PDOO - Practice 1 DeepSpace
 */
package deepspace;
import java.util.ArrayList;

/**
 * @title Hangar
 * @brief 
 */
public class GameUniverse {
    private final int WIN =10;
    private int currentStationIndex;
    private int turns;
    private Dice dice;
    private SpaceStation currentStation;
    private ArrayList<SpaceStation> spaceStations;
    private EnemyStarShip currentEnemy;
    
    /**
    * @brief Constructor
    */
    protected GameUniverse (){
        throw new UnsupportedOperationException();
    }
    
    /**
    * @brief  
    * @return 
    */
    protected CombatResult combat(SpaceStation station, EnemyStarShip enemy){
        throw new UnsupportedOperationException();
    }
    
    /**
    * @brief  
    * @return 
    */
    CombatResult combat(){
        throw new UnsupportedOperationException();
    }
    
    /**
    * @brief  
    * @return 
    */
    void discardHangar(){
        throw new UnsupportedOperationException();
    }
    
    /**
    * @brief  
    * @return 
    */
    void discardShieldBooster(int i){
        throw new UnsupportedOperationException();
    }
    
    /**
    * @brief  
    * @return 
    */
    void discardShieldBoosterInHangar(int i){
        throw new UnsupportedOperationException();
    }
    
    /**
    * @brief  
    * @return 
    */
    void discardWeapon(int i){
        throw new UnsupportedOperationException();
    }
    
    /**
    * @brief  
    * @return 
    */
    void discardWeaponInHangar(int i){
        throw new UnsupportedOperationException();
    }
    
    /**
    * @brief  
    * @return 
    */
    GameState getState(){
        throw new UnsupportedOperationException();
    }
    
    /**
    * @brief builds a new GameUniverseToUI object from *this
    * @return GameUniverseToUI
    */
    GameUniverseToUI getUIversion(){
        return new GameUniverseToUI (this);
    }
    
    /**
    * @brief  
    * @return 
    */
    boolean haveAWinner(){
        throw new UnsupportedOperationException();
    }
    
    /**
    * @brief  
    * @return 
    */
    void init(String[] names){
        throw new UnsupportedOperationException();
    }
    
    /**
    * @brief  
    * @return 
    */
    void mountShieldBooster(int i){
        throw new UnsupportedOperationException();
    }
    
    /**
    * @brief  
    * @return 
    */
    void mountWeapon(int i){
        throw new UnsupportedOperationException();
    }
    
    /**
    * @brief  
    * @return 
    */
    boolean nextTurn(){
        throw new UnsupportedOperationException();
    }
    
 
    
}
