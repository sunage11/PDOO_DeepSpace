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
public class EnemyStarShip implements SpaceFighter {
    private float ammoPower;
    private String name;
    private float shieldPower;
    private Loot loot;
    private Damage damage;
    
    /**
    * @brief Constructor
    */
    EnemyStarShip (String n, float a, float s, Loot l, Damage d){
        name = n;
        ammoPower = a;
        shieldPower = s;
        loot = l;
        damage = d;
    }
    
    /**
    * @brief Copy constructor
    */
    EnemyStarShip (EnemyStarShip e){
        name = e.name;
        ammoPower = e.ammoPower;
        shieldPower = e.shieldPower;
        loot = e.loot;
        damage = e.damage;
    }
    
    /**
    * @brief builds a new WeaponToUI object from *this
    * @return EnemyToUI
    */
    EnemyToUI getUIversion () { 
        
        return new EnemyToUI (this);
    }
    
    /**
    * @brief returns the shoot energy level of the enemy ship
    * @return ammoPower
    */
    @Override
    public float fire(){
        return ammoPower;
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
        Damage output = damage;
        return output;
    }
    
    /**
    * @brief  Getter with package visibility
    * @return loot object
    */
    Loot getLoot(){
       // Loot output = new Loot (loot);
       // return output;
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
    * @brief  returns the shield energy level of the enemy ship
    * @return shieldPower
    */
    @Override
    public float protection(){
        return shieldPower;
    }
    
    /**
    * @brief  returns the result of a received shot with a specific power
    * @param shot power of the shot
    * @return the result of the shot
    */
    @Override
    public ShotResult receiveShot (float shot){
        if (shot > shieldPower)
            return ShotResult.DONOTRESIST;
        else 
            return ShotResult.RESIST;
    }
    
    /**
    * @brief toString
    * @return String with info about the instance
    */
    @Override
    public String toString () {
        
        String output = "EnemyStarShip [ name " + name 
                        + " ; ammoPower " + ammoPower
                        + " ; shieldPower " + shieldPower
                        + " ; loot " + loot.toString()
                        + " ; damage " + damage.toString() + " ]";
        
        return output;
    
    }
    
    
}
