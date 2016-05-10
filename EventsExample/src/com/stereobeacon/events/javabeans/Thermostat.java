/*
 * Thermostat.java
 *
 * Created on January 1, 2002, 4:48 PM
 */

package com.stereobeacon.events.javabeans;

/**
 *
 * @author  pmonday@stereobeacon.com
 * @version 1.0
 */
public class Thermostat implements java.beans.PropertyChangeListener {

    /** Holds value of property heater. */
    private boolean heater;
    
    private static final boolean debug = true;
    
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
    
    public void propertyChange(java.beans.PropertyChangeEvent propertyChangeEvent) {
        if(propertyChangeEvent.getPropertyName().equals("temperature")){
            int temp = ((Integer)propertyChangeEvent.getNewValue()).intValue();
            if(temp < 64) {
                setHeater(true);
            } else {
                setHeater(false);
            }
        }
    }
    
}
