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
    GameUniverse (){
        gameState = new GameStateController();
        turns = 0;
        dice = new Dice();
        
    }
    
    /**
    * @brief  
    * @return 
    */
    CombatResult combat(SpaceStation station, EnemyStarShip enemy){
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
    * @brief discards hangar of the current station if gameState is INIT or 
    * AFTERCOMBAT
    */
    void discardHangar(){
        if (gameState.getState() == GameState.AFTERCOMBAT || 
                gameState.getState() == GameState.INIT)
            currentStation.discardHangar();
    }
    
    /**
    * @brief discards shield booster i of the current station if gameState is 
    * INIT or AFTERCOMBAT
    */
    void discardShieldBooster(int i){
        if (gameState.getState() == GameState.AFTERCOMBAT || 
                gameState.getState() == GameState.INIT)
            currentStation.discardShieldBooster(i);
    }
    
    /**
    * @brief discards shield booster i of the current station's hangar if 
    * gameState is INIT or AFTERCOMBAT
    */
    void discardShieldBoosterInHangar(int i){
        if (gameState.getState() == GameState.AFTERCOMBAT || 
                gameState.getState() == GameState.INIT)
            currentStation.discardShieldBoosterInHangar(i);
    }
    
    /**
    * @brief discards weapon i of the current station if gameState is INIT or AFTERCOMBAT
    */
    void discardWeapon(int i){
        if (gameState.getState() == GameState.AFTERCOMBAT || 
                gameState.getState() == GameState.INIT)
            currentStation.discardWeapon(i);
    }
    
    /**
    * @brief discards weapon i of the current station's hangar if 
    * gameState is INIT or AFTERCOMBAT
    */
    void discardWeaponInHangar(int i){
        if (gameState.getState() == GameState.AFTERCOMBAT || 
                gameState.getState() == GameState.INIT)
            currentStation.discardWeaponInHangar(i);
    }

    
    /**
    * @brief  getter with package visibility
    * @return gameState state
    */
    GameState getState(){
        return gameState.getState();
    }
    
    /**
    * @brief builds a new GameUniverseToUI object from currentEnemy and currentStation
    * @return GameUniverseToUI
    */
    GameUniverseToUI getUIversion(){
        return new GameUniverseToUI (currentStation,currentEnemy);
    }
    
    /**
    * @brief  It returns true if the current space station has the number of 
    * medals needed to win.
    * @return true if medals is equal to WIN. Otherwise, it is false.
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
    * @brief If the game state is INIT or AFTERCOMBAT, the  current space 
    * station calls its own method mountShieldBooster. Otherwise, it has no effect.
    */
    void mountShieldBooster(int i){
        if (gameState.getState() == GameState.AFTERCOMBAT || 
                gameState.getState() == GameState.INIT)
            currentStation.mountShieldBooster(i);
    }
    
    /**
    * @brief  If the game state is INIT or AFTERCOMBAT, the  current space 
    * station calls its own method mountWeapon. Otherwise, it has no effect.
    */
    void mountWeapon(int i){
        if (gameState.getState() == GameState.AFTERCOMBAT || 
                gameState.getState() == GameState.INIT)
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
