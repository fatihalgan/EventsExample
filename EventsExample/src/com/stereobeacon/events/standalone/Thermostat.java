/*
 * Thermostat.java
 *
 * Created on January 1, 2002, 4:48 PM
 */

package com.stereobeacon.events.standalone;

import java.util.Vector;

/**
 *
 * @author  pmonday@stereobeacon.com
 * @version 1.0
 */
public class Thermostat implements TemperatureChangeListener {
    
    /** Holds value of property heater. */
    private boolean heater;
    
    private static final boolean debug = true;

    private Vector coldRooms = new Vector(2);
    
    /** Creates new Thermostat */
    public Thermostat() {
    }
    
    /** Getter for property heater.
     * @return Value of property heater.
     */
    public boolean isHeater() {
        return heater;
    }
    
    /** Setter for property heater.
     * @param heater New value of property heater.
     */
    public void setHeater(boolean heater) {
        if(heater != this.heater){
            if(debug) System.out.println("INFO::Thermostat::setHeater "+heater);
            this.heater = heater;
        }
    }
    
    public void updateTemperature(TemperatureChangeEvent temperatureChangeEvent) {
        int newTemp = temperatureChangeEvent.getNewTemperature();
        int oldTemp = temperatureChangeEvent.getOldTemperature();
        String location = temperatureChangeEvent.getLocation();
        
        if(newTemp < 64 && !coldRooms.contains(location)){
            coldRooms.add(location);
            if(coldRooms.size()==1){
                setHeater(true);
            }
        } else if(newTemp > 64 && coldRooms.contains(location)){
            coldRooms.remove(location);
            if(coldRooms.size()==0){
                setHeater(false);
            }
        }
    }
    
}
