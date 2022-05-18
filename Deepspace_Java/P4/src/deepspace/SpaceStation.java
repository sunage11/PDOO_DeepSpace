/**
 * @author BOLÍVAR PELÁEZ, CLARA
 * @author RUIZ GÓMEZ, SOLEDAD
 * 2º DGIIM - PDOO - Practice 2 DeepSpace
 */
package deepspace;

import java.util.ArrayList;
import java.util.Iterator;

import java.util.stream.Collectors;

/**
 *
 * @author sunage
 */
public class SpaceStation implements SpaceFighter {
    
    private final int MAXFUEL = 100; //Shield units that are lost for each 
    //unit of firing power received.
    private final int SHIELDLOSSPERUNITSHOT = 100; //Greatest number of fuel 
    //units that a space station can have.
    
    private float ammoPower;
    private float fuelUnits;
    private String name;
    private int nMedals;
    private float shieldPower;
    private Damage pendingDamage;
    private ArrayList<Weapon> weapons;
    private ArrayList<ShieldBooster> shieldBoosters;
    private Hangar hangar;
    
    
    /**
    * @brief Constructor
    * @param n name
    * @param supplies a instance os SuppliesPackage
    */
    SpaceStation (String n, SuppliesPackage supplies) {
        ammoPower = supplies.getAmmoPower();
        fuelUnits = supplies.getFuelUnits();
        shieldPower = supplies.getShieldPower();
        name = n;
        nMedals = 0;
        pendingDamage= null;
        hangar = null;
        weapons = new ArrayList<>();
        shieldBoosters = new ArrayList<>();
    }
    
    /**
    * @brief Constructor
    * @param other instance od spaceStation
    */
    
    SpaceStation (SpaceStation other){
        ammoPower = other.getAmmoPower();
        fuelUnits = other.getFuelUnits();
        shieldPower = other.getShieldPower();
        name = other.getName();
        nMedals = other.getNMedals();
        if (other.getPendingDamage()!=null)
            pendingDamage= other.getPendingDamage();
        else
            pendingDamage=null;
        
        if (other.getHangar()!=null)
            hangar= other.getHangar();
        else
            hangar=null;
        
        if (other.getWeapons()!=null)
            weapons= other.getWeapons();
        else
            weapons = new ArrayList<>();
        
        if (other.getShieldBoosters()!=null)
            shieldBoosters= other.getShieldBoosters();
        else
            shieldBoosters = new ArrayList<>();
    }
    
    
    /**
    * @brief Set the amount of fuel to the value passed without ever 
    * exceeding the limit.
    * @param f value 
    */
    void assignFuelValue (float f) {
        if (f<=MAXFUEL)
            fuelUnits = f;
        else
            fuelUnits = MAXFUEL;
    }
    
    /**
    * @brief Set pending damage to null if it has no effect.
    */
    void cleanPendingDamage () {
        if(pendingDamage.hasNoEffect())
            pendingDamage = null;
    }
    
    /**
    * @brief It eliminates all mounted weapons and boosters that do not have 
    * any use left.
    */
    void cleanUpMountedItems () {
        
        weapons = new ArrayList<>(weapons.stream().filter(weapon -> weapon.getUses() > 0).collect(Collectors.toList()));
        
        shieldBoosters = new ArrayList<>(shieldBoosters.stream().filter(shieldBooster -> shieldBooster.getUses() > 0).collect(Collectors.toList()));
                
    }
    
    /**
    * @brief Set the reference of the hangar to null to indicate that it 
    * is not available.
    */
    void discardHangar () {
        hangar = null;
    }
    
    /**
    * @brief an attempt is made to discard the shield booster with index i from 
    * the current shield booster pool. In addition to losing the shield boost, 
    * it updates the pending damage if there is any
    * @param i index of the shield
    */
    void discardShieldBooster (int i) {
        int size= shieldBoosters.size();
        
        if(i>=0 && i < size){
            shieldBoosters.remove(i);
            
            if(pendingDamage!=null){
                pendingDamage.discardShieldBooster();
                cleanPendingDamage();
            }
        }
    }
    
    /**
    * @brief If a hangar is available, it is requested to discard the booster 
    * with index i.
    * @param i index
    */
    void discardShieldBoosterInHangar (int i) {
        if(hangar!=null)
            hangar.removeShieldBooster(i);
    }
    
    /**
    * @brief It tries to discard the weapon i of the array weapons. Apart from
    * losing the weapon, it should update the pendingDamage if there is any.
    * @param i index of the weapon
    */
    void discardWeapon (int i) {
        int size= weapons.size();
        
        if(i>=0 && i < size){
            Weapon w = weapons.remove(i);
            
            if(pendingDamage!=null){
                pendingDamage.discardWeapon(w);
                cleanPendingDamage();
            }
        }
    }
    
    /**
    * @brief 
    * @param i index of the 
    */
    void discardWeaponInHangar (int i) {
        if(hangar!=null)
            hangar.removeWeapon(i);
        
    }
    
    /**
    * @brief It makes a shot and it returns its energy or power. To do this, the
    * firing power is multiplied by the enhancing factors provided by all weapons.
    * @return its energy or power
    */
    @Override
    public float fire () {

        float factor = 1;
        Iterator<Weapon> it = weapons.iterator();
         
        while (it.hasNext()) {
            Weapon w = it.next();
            factor *= w.useIt();
        }
        
        return ammoPower*factor;
    }

    
    /**
    * @brief Getter with package visibility
    * @return ammoPower value
    */
    float getAmmoPower () {
        return (ammoPower);
    }
    
    /**
    * @brief Getter with package visibility
    * @return fuelUnits value
    */
    float getFuelUnits () {
        return (fuelUnits);
    }
    
    /**
    * @brief Getter with package visibility
    * @return Hangar instance
    */
    Hangar getHangar () {
        return hangar;
    }
    
    /**
    * @brief Getter with package visibility
    * @return name value
    */
    String getName () {
        return (name);
    }
    
    /**
    * @brief Getter with package visibility
    * @return nMedals value 
    */
    int getNMedals () {
        return(nMedals);
    }
    
    /**
    * @brief Getter with package visibility
    * @return pendingDamage instance
    */
    Damage getPendingDamage () {
        return pendingDamage;
    }
    
    /**
    * @brief Getter with package visibility
    * @return collection of ShieldBoosters
    */
    ArrayList<ShieldBooster> getShieldBoosters () {
        ArrayList<ShieldBooster> output = new ArrayList<>(shieldBoosters);
        return output;
    }
    
    /**
    * @brief Getter with package visibility
    * @return shieldPower instance
    */
    float getShieldPower () {
        return (shieldPower);
    }
    
    
    /**
    * @brief Getter with package visibility
    * @param d another Damage instance
    */
    float getSpeed () {
        return(fuelUnits/MAXFUEL);
    }
    
    /**
    * @brief builds a new SpaceStationToUI object from *this
    * @return WeaponToUI
    */
    SpaceStationToUI getUIversion () {
        return new SpaceStationToUI (this);
    }
    
    /**
    * @brief Getter with package visibility
    * @return collection of Weapons
    */
    ArrayList<Weapon> getWeapons () {
        return (weapons);
    }
    
    /**
    * @brief It tries to mount the booster with the index i inside the hangar. If 
    * a hangar is available, it removes the booster located in that position 
    * and if this operation is successful, it is added to the collection of
    * boosters in use.
    * @param i index
    */
    void mountShieldBooster (int i) {
        if (hangar != null) {
            ShieldBooster aux;
            aux = hangar.removeShieldBooster(i);
            if (aux != null)
                shieldBoosters.add(aux);
        }
    }
    
    /**
    * @brief It trys to mount the weapon with the index i inside the hangar. If 
    * a hangar is available, it removes the weapon located in that position 
    * and if this operation is successful, it is added to the collection of
    * weapons in use.
    * @param i index
    */
    void mountWeapon (int i) {
        if (hangar != null) {
            Weapon aux;
            aux = hangar.removeWeapon(i);
            if (aux != null) 
                weapons.add(aux);
        }
    }
    
    /**
    * @brief decrease in fuel units due to a displacement. The number of stored 
    * units is subtracted a fraction that is equal to the speed of the station
    * fuelUnits cannot be a negative 
    */
    void move () {
        fuelUnits -= getSpeed();
    }
    
    /**
    * @brief  It uses the protective shield and returns its energy. To do this, 
    * the power of the shield is multiplied by the enhancing factors provided by
    * all the shield enhancers available.
    * @return the energy of the protective shield
    */
    @Override
    public float protection () {
        float factor = 1;
        Iterator<ShieldBooster> it = shieldBoosters.iterator();
         
        while (it.hasNext()) {
            ShieldBooster s = it.next();
            factor *= s.useIt();
        }
        
        return shieldPower*factor;
    }
    
    /**
    * @brief if *this has not hangar, param h is the new hangar. If *this already 
    * has hangar, this method does not operate
    * @param h hangar to clone
    */
    void receiveHangar (Hangar h) {
        if (hangar == null)
            hangar = new Hangar(h);
    }
    
    /**
    * @brief if *this has not hangar, returns false. Otherwise, it returns the 
    * result of trying to add the shield booster s to the hangar
    * @param s shield booster to add
    * @return true if added, false otherwise
    */
    boolean receiveShieldBooster (ShieldBooster s) {
        if (hangar == null)
            return false;
        else
            return hangar.addShieldBooster(s);
    }
    
    /**
    * @brief  performs operations related to receiving the impact of an enemy shot.
    * This involves decreasing the power os the shield depending on the energy 
    * of the shot received as a parameter.
    * @param shot energy of the shot
    * @return  the result of whether the shot has been resisted or not
    */
    @Override
    public ShotResult receiveShot (float shot) {
        
        float myProtection = protection();
        
        if (myProtection >= shot) {
            shieldPower -= SHIELDLOSSPERUNITSHOT*shot;
            shieldPower = Float.max(0.0f, shieldPower);
            return ShotResult.RESIST;
        } else {
            shieldPower = 0.0f;
            return ShotResult.DONOTRESIST;
        }
    }
    
    /**
    * @brief increments ammoPower, shieldPower and fuelUnits 
    * @param s supplies package 
    */
    void receiveSupplies (SuppliesPackage s) {
        ammoPower += s.getAmmoPower();
        shieldPower += s.getShieldPower();
        fuelUnits += s.getFuelUnits();
    }
    
    /**
    * @brief if *this has not hangar, returns false. Otherwise, it returns the 
    * result of trying to add the weapon w to the hangar
    * @param w weapon to add
    * @return true if added, false otherwise
    */
    boolean receiveWeapon (Weapon w) {
        if (hangar == null)
            return false;
        else
            return hangar.addWeapon(w);
    }
    
    /**
    * @brief for earch element that indicates the loot (passed as a parameter) 
    * CardDealer is asked for an element of that type and it tries to store 
    * using the receive method.For medals, their number is simply increased 
    * according to what the loot indicates.
    * @return WeaponToUI
    */
    Transformation setLoot (Loot loot) {

        CardDealer dealer = CardDealer.getInstance();
       
        int h = loot.getNHangars();   
        if (h>0) {
            Hangar hangar = dealer.nextHangar();
            receiveHangar(hangar);
        }
        
        int elements = loot.getNSupplies();
        for (int i=1; i<=elements; i++) {
            SuppliesPackage sup = dealer.nextSuppliesPackage();
            receiveSupplies(sup);
        }
        
        elements = loot.getNWeapons();
        for (int i=1; i<=elements; i++) {
            Weapon weap = dealer.nextWeapon();
            receiveWeapon(weap);
        }
        
        elements = loot.getNShields();
        for (int i=1; i<=elements; i++) {
            ShieldBooster sh = dealer.nextShieldBooster();
            receiveShieldBooster(sh);
        }
        
        int medals = loot.getNMedals();
        nMedals+=medals;
        
        if(loot.getEfficient()){
           return Transformation.GETEFFICIENT;
       }
       else if(loot.spaceCity()){
           return Transformation.SPACECITY;
       }
       else{
           return Transformation.NOTRANSFORM;
       }
        
    }
    
    /**
    * @brief calculates the adjusted damage from param d to the weapon and shield
    * collections in *this and then saves it in pendingDamage
    * @param d Damage to adjust
    */
    void setPendingDamage (Damage d) {
        pendingDamage = d.adjust(weapons, shieldBoosters);
    }
    
    /**
    * @brief returns true if *this is in a valid state (this implies not to have
    * any pendingDamage at all or with any effect
    * @return true if *this is in a valid state, false otherwise
    */
    boolean validState () {
        return ((pendingDamage == null) || (pendingDamage.hasNoEffect()));
    }
    
    /**
    * @brief toString
    * @return String with info about the instance
    */
    @Override
    public String toString () {
        
        String output = "SpaceStation [ MAXFUEL " + MAXFUEL 
                        + " ; SHIELDLOSSPERUNITSHOT " + SHIELDLOSSPERUNITSHOT 
                        + " ; ammoPower " + ammoPower +" ; fuelUnits " + fuelUnits 
                            +" ; name " + name +" ; nMedals "+ nMedals +" ; shieldPower "+
                                shieldPower + " ; pendingDamage "+ pendingDamage+
                            " ; weapons " + weapons.toString() + " ; shieldBoosters " + 
                            shieldBoosters + " ; hangar " + hangar + " ]";
        
        return output;
    }
 
}
