/**
 * @author BOLÍVAR PELÁEZ, CLARA
 * @author RUIZ GÓMEZ, SOLEDAD
 * 2º DGIIM - PDOO - Practice 2 DeepSpace
 */
package deepspace;
import java.util.ArrayList;

/**
 * @title GameUniverse
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
    boolean haveSpaceCity;
    
    /**
    * @brief Constructor
    */
    public GameUniverse (){
        gameState = new GameStateController();
        turns = 0;
        dice = new Dice();
        currentStation = null;
        spaceStations = new ArrayList<>();
        currentEnemy = null;
        currentStationIndex=-1;

    }
    
    void createSpaceCity(){}
    
    void makeStationEfficient(){}
    
    /**
    * @brief A combat between the space station and the enemy that are received
    * as parameters takes place. The procedure described in the rules of the 
    * game is followed: draw for who shoots first, possibility of escape, 
    * allocation of loot, recording of pending damage, etc. 
    * The result of the combat is returned.
    * @param station SpaceStation to fight
    * @param enemy EneyStarship to fight
    * @return combat result
    */
    CombatResult combat(SpaceStation station, EnemyStarShip enemy){
        
        GameCharacter ch = dice.firstShot();
        
        float fire;
        ShotResult result;
        boolean enemyWins;
        CombatResult combatResult;
        
        if (ch == GameCharacter.ENEMYSTARSHIP) {
            
            fire = enemy.fire();
            result = station.receiveShot(fire);
            
            if (result == ShotResult.RESIST) {
                
                fire = station.fire();
                result = enemy.receiveShot(fire);
                
                enemyWins = (result==ShotResult.RESIST);                
            
            } else {
                enemyWins = true;
            }
            
        } else {
            
            fire = station.fire();
            result = enemy.receiveShot(fire);
            enemyWins = (result==ShotResult.RESIST); 
        }
        
        
        if (enemyWins) {
            
            float s = station.getSpeed();
            boolean moves = dice.spaceStationMoves(s);
            
            if (moves) {
                
                Damage damage = enemy.getDamage();
                station.setPendingDamage(damage);
                
                combatResult = CombatResult.ENEMYWINS;
 
            } else {
                
                station.move();
                combatResult = CombatResult.STATIONESCAPES;
            }
            
        } else {
            
            Loot aLoot = enemy.getLoot();
            station.setLoot(aLoot);
            combatResult = CombatResult.STATIONWINS;
        }
        
        
        gameState.next(turns, spaceStations.size());
        
        return combatResult; 
        
    }
    
    /**
    * @brief  
    * @return 
    */
    public CombatResult combat(){
        
        GameState state = gameState.getState();
        
        if (state == GameState.BEFORECOMBAT || state == GameState.INIT) 
            return combat (currentStation, currentEnemy);
        else
            return CombatResult.NOCOMBAT;
    }
    
    /**
    * @brief discards hangar of the current station if gameState is INIT or 
    * AFTERCOMBAT
    */
    public void discardHangar(){
        if (gameState.getState() == GameState.AFTERCOMBAT || 
                gameState.getState() == GameState.INIT)
            currentStation.discardHangar();
    }
    
    /**
    * @brief discards shield booster i of the current station if gameState is 
    * INIT or AFTERCOMBAT
    */
    public void discardShieldBooster(int i){
        if (gameState.getState() == GameState.AFTERCOMBAT || 
                gameState.getState() == GameState.INIT)
            currentStation.discardShieldBooster(i);
    }
    
    /**
    * @brief discards shield booster i of the current station's hangar if 
    * gameState is INIT or AFTERCOMBAT
    */
    public void discardShieldBoosterInHangar(int i){
        if (gameState.getState() == GameState.AFTERCOMBAT || 
                gameState.getState() == GameState.INIT)
            currentStation.discardShieldBoosterInHangar(i);
    }
    
    /**
    * @brief discards weapon i of the current station if gameState is INIT or AFTERCOMBAT
    */
    public void discardWeapon(int i){
        if (gameState.getState() == GameState.AFTERCOMBAT || 
                gameState.getState() == GameState.INIT)
            currentStation.discardWeapon(i);
    }
    
    /**
    * @brief discards weapon i of the current station's hangar if 
    * gameState is INIT or AFTERCOMBAT
    */
    public void discardWeaponInHangar(int i){
        if (gameState.getState() == GameState.AFTERCOMBAT || 
                gameState.getState() == GameState.INIT)
            currentStation.discardWeaponInHangar(i);
    }

    
    /**
    * @brief  getter with package visibility
    * @return gameState state
    */
    public GameState getState(){
        return gameState.getState();
    }
    
    /**
    * @brief builds a new GameUniverseToUI object from currentEnemy and currentStation
    * @return GameUniverseToUI
    */
    public GameUniverseToUI getUIversion(){
        return new GameUniverseToUI (currentStation,currentEnemy);
    }
    
    /**
    * @brief  It returns true if the current space station has the number of 
    * medals needed to win.
    * @return true if medals is equal to WIN. Otherwise, it is false.
    */
    public boolean haveAWinner(){
        if(currentStation.getNMedals() == WIN)
            return true;
        else
            return false; 
    }
    
    /**
    * @brief  
    * @return 
    */
    public void init(ArrayList<String> names){
        
        GameState state = gameState.getState();
        
        if (state==GameState.CANNOTPLAY) {
            
            spaceStations = new ArrayList<>();
            CardDealer dealer = CardDealer.getInstance();
            
            int size = names.size();
            for (int i=0; i<size; i++) {
                
                SuppliesPackage supplies = dealer.nextSuppliesPackage();
                SpaceStation station = new SpaceStation (names.get(i), supplies);
                spaceStations.add(station);
                
                int nh = dice.initWithNHangars();
                int nw = dice.initWithNWeapons();
                int ns = dice.initWithNShields();
                
                Loot lo = new Loot (0, nw, ns, nh, 0,false,false);
                station.setLoot(lo);
                
            }
            
            currentStationIndex = dice.whoStarts(size);
            currentStation = spaceStations.get(currentStationIndex);
            
            currentEnemy = dealer.nextEnemy();
            
            gameState.next(turns, spaceStations.size());
     
        }   
        
    }
    
    /**
    * @brief If the game state is INIT or AFTERCOMBAT, the  current space 
    * station calls its own method mountShieldBooster. Otherwise, it has no effect.
    */
    public void mountShieldBooster(int i){
        if (gameState.getState() == GameState.AFTERCOMBAT || 
                gameState.getState() == GameState.INIT)
            currentStation.mountShieldBooster(i);
    }
    
    /**
    * @brief  If the game state is INIT or AFTERCOMBAT, the  current space 
    * station calls its own method mountWeapon. Otherwise, it has no effect.
    */
    public void mountWeapon(int i){
        if (gameState.getState() == GameState.AFTERCOMBAT || 
                gameState.getState() == GameState.INIT)
            currentStation.mountWeapon(i);
    }
    
    /**
    * @brief  
    * @return 
    */
    public boolean nextTurn(){
        
        GameState state = gameState.getState();
        
        if (state == GameState.AFTERCOMBAT) {
            
            boolean stationState = currentStation.validState();
            
            if (stationState) {
                
                int size = spaceStations.size();
                
                currentStationIndex = (currentStationIndex+1) % size;
                turns++;
                
                currentStation = spaceStations.get(currentStationIndex);
                currentStation.cleanUpMountedItems();
                
                CardDealer dealer = CardDealer.getInstance();
                
                currentEnemy = dealer.nextEnemy();
                
                gameState.next(turns, size);
                
                return true;
            }
            
            return false;
        }
        
        return false;
    }
    
    /**
    * @brief toString
    * @return String with info about the instance
    */
    @Override
    public String toString () {
        
        String output = "GameUniverse [ gameState " + gameState 
                        + " ; turns " + turns 
                        + " ; dice " + dice.toString()
                        + " ; currentStation " + currentStation
                        + " ; spaceStations " + spaceStations.toString()
                        + " ; currentEnemy " + currentEnemy + " ]";
        
        return output;
    }
 
    
}
