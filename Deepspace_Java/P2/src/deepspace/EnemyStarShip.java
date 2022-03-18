/**
 * @author BOLÍVAR PELÁEZ, CLARA
 * @author RUIZ GÓMEZ, SOLEDAD
 * 2º DGIIM - PDOO - Practice 1 DeepSpace
 */
package deepspace;

/**
 * @title Hangar
 * @brief 
 */
public class EnemyStarShip {
    private float ammoPower;
    private String name;
    private float shieldPower;
    private GameUniverse gameUniverse;
    private Loot loot;
    private Damage damage;
    
    /**
    * @brief Constructor
    */
    protected EnemyStarShip (String n, float a, float s, Loot l, Damage d){
        throw new UnsupportedOperationException();
    }
    
    /**
    * @brief Copy constructor
    */
    protected EnemyStarShip (EnemyStarShip e){
        throw new UnsupportedOperationException();
    }
    
    /**
    * @brief builds a new WeaponToUI object from *this
    * @return EnemyToUI
    */
    protected EnemyToUI getUIVersion () { //DUDAAAA protected
        
        return new EnemyToUI (this);
    }
    
    /**
    * @brief  
    * @return 
    */
    float fire(){
        throw new UnsupportedOperationException();
    }
    
    /**
    * @brief  Getter with package visibility
    * @return ammoPower value
    */
    float getAmmoPower(){
        return ammoPower;
    }
    
    /**
    * @brief  Getter with package visibility
    * @return damage value
    */
    Damage getDamage(){
      return damage;
    }
    
    /**
    * @brief  Getter with package visibility
    * @return loot object
    */
    Loot getLoot(){
        return loot;
    }
    
    /**
    * @brief  Getter with package visibility
    * @return name value
    */
    String getName(){
        return name;
    }
    
    /**
    * @brief  Getter with package visibility
    * @return shieldPower value
    */
    float getShieldPower(){
        return shieldPower;
    }
    
    /**
    * @brief  
    * @return 
    */
    float protection(){
        throw new UnsupportedOperationException();
    }
    
    /**
    * @brief  
    * @return 
    */
    ShotResult receive(float shot){
        throw new UnsupportedOperationException();
    }
    
    
}
