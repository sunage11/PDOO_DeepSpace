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
    private GameStateController gameState;
    
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
    * @brief  It returns true if the current space station has the number of 
    * medals needed to win.
    * @return true when the number of medals is equal as the one required to 
    * win, otherwise, it returns false
    * 
    */
    boolean haveAWinner(){
        if(currentStation.getNMedals() == WIN)
            return true;
        else
            return false;
    }
    
    /**
    * @brief  
    * @return 
    */
    void init(String[] names){
        throw new UnsupportedOperationException();
    }
    
    /**
    * @brief  If the state of the game is INIT or AFTERCOMBAT the current space
    * station call mountShieldBooster with the index passed as parameter.
    * Otherwise, it has no effect.
    * @return i index 
    */
    void mountShieldBooster(int i){
        if((gameState.getState() == GameState.INIT) || (gameState.getState() == GameState.AFTERCOMBAT))
            currentStation.mountShieldBooster(i);
    }
    
    /**
    * @brief  If the state of the game is INIT or AFTERCOMBAT the current space
    * station call mountWeapon with the index passed as parameter.
    * Otherwise, it has no effect.
    * @param i index
    */
    void mountWeapon(int i){
        if((gameState.getState() == GameState.INIT) || (gameState.getState() == GameState.AFTERCOMBAT))
            currentStation.mountWeapon(i);
    }
    
    /**
    * @brief  
    * @return 
    */
    boolean nextTurn(){
        throw new UnsupportedOperationException();
    }
    
 
    
}
