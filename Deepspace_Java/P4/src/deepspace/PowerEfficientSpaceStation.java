/**
 * @author BOLÍVAR PELÁEZ, CLARA
 * @author RUIZ GÓMEZ, SOLEDAD
 * 2º DGIIM - PDOO - Practice 1 DeepSpace
 */
package deepspace;

/**
 * @title NumericDamage
 * @brief It represents the damage that an enemy starship makes to a
 * spacial station when it loses a combat
 */
public class PowerEfficientSpaceStation extends SpaceStation {
    
    private static final float EFFICIENCYFACTOR=1.10f;
    
    PowerEfficientSpaceStation (SpaceStation station){
        super(station);
    }
    
    @Override
    public float fire(){
        return super.fire()*EFFICIENCYFACTOR;
    }
    
    @Override
    public float protection(){
        return super.protection()*EFFICIENCYFACTOR;
    }
    
    @Override
    Transformation setLoot(Loot loot){
        
        Transformation output = super.setLoot(loot);
        if (output == Transformation.SPACECITY)
            return Transformation.NOTRANSFORM;
        else
            return output;        
    }
    
    /**
    * @brief builds a new PowerEfficientSpaceStationToUI object from *this
    * @return WeaponToUI
    */
    PowerEfficientSpaceStationToUI getUIversion () {
        return new PowerEfficientSpaceStationToUI (this);
    }
    
    
    
    
}
