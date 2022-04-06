/**
 * @author BOLÍVAR PELÁEZ, CLARA
 * @author RUIZ GÓMEZ, SOLEDAD
 * 2º DGIIM - PDOO - Practice 2 DeepSpace
 */
package deepspace;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author sunage
 */
public class SpaceStation {
    
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
        
        Iterator<Weapon> it = weapons.iterator();
        Iterator<ShieldBooster> it2 = shieldBoosters.iterator();
        
        while(it.hasNext()){
            Weapon aux = it.next();
            if(aux.getUses() == 0)
                weapons.remove(aux);
        }
        
        while(it2.hasNext()){
            ShieldBooster aux2 = it2.next();
            if(aux2.getUses() == 0)
                shieldBoosters.remove(aux2);
        }
        
        
    }
    
    /**
    * @brief Set the reference of the hangar to null to indicate that it 
    * is not available.
    */
    void discardHangar () {
        hangar = null;
    }
    
    /**
    * @brief 
    * @param 
    */
    void discardShieldBooster (int i) {
        throw new UnsupportedOperationException();
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
    * @brief Copy constructor
    * @param d another Damage instance
    */
    void discardWeapon (int i) {
        throw new UnsupportedOperationException();
    }
    
    /**
    * @brief If a hangar is available, it is requested to discard the weapon 
    * with index i.
    * @param i index
    */
    void discardWeaponInHangar (int i) {
        if(hangar!=null)
            hangar.removeWeapon(i);
        
    }
    
    /**
    * @brief Copy constructor
    * @param d another Damage instance
    */
    float fire () {
        throw new UnsupportedOperationException();
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
        Hangar output = new Hangar (hangar);
        return output;
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
        Damage output = new Damage (pendingDamage);
        return output;
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
    * @brief builds a new WeaponToUI object from *this
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
    * @brief builds a new WeaponToUI object from *this
    * @return WeaponToUI
    */
    float protection () {
        throw new UnsupportedOperationException();
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
    * @brief builds a new WeaponToUI object from *this
    * @return WeaponToUI
    */
    ShotResult receiveShot (float shot) {
        throw new UnsupportedOperationException();
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
    * @brief builds a new WeaponToUI object from *this
    * @return WeaponToUI
    */
    void setLoot (Loot loot) {
        throw new UnsupportedOperationException();
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
    public String toString () {
        
        String output = "SpaceStation [ MAXFUEL " + MAXFUEL 
                        + " ; SHIELDLOSSPERUNITSHOT " + SHIELDLOSSPERUNITSHOT 
                        + " ; ammoPower " + ammoPower +" ; fuelUnits " + fuelUnits 
                            +" ; name " + name +" ; nMedals "+ nMedals +" ; shieldPower "+
                                shieldPower + " ; pendingDamage "+ pendingDamage.toString()+
                            " ; weapons " + weapons.toString() + " ; shieldBoosters " + 
                            shieldBoosters.toString() + " ; hangar " + hangar.toString() + " ]";
        
        return output;
    }
 
}
