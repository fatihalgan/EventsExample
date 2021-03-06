/*
 * TemperatureChangeEvent.java
 *
 * Created on January 2, 2002, 7:31 PM
 */

package com.stereobeacon.events.messages;

/**
 *
 * @author  default
 * @version 
 */
public class TemperatureChangeEvent extends java.util.EventObject {

    /** Holds value of property newTemperature. */
    private int newTemperature;
    
    /** Holds value of property oldTemperature. */
    private int oldTemperature;
    
    /** Creates new TemperatureChangeEvent */
    public TemperatureChangeEvent(Object source, int oldTemp, int newTemp){
        super(source);
        oldTemperature = oldTemp;
        newTemperature = newTemp;
    }
    
    /** Getter for property newTemperature.
     * @return Value of property newTemperature.
     */
    public int getNewTemperature() {
        return newTemperature;
    }
    
    /** Setter for property newTemperature.
     * @param newTemperature New value of property newTemperature.
     */
    public void setNewTemperature(int newTemperature) {
        this.newTemperature = newTemperature;
    }
    
    /** Getter for property oldTemperature.
     * @return Value of property oldTemperature.
     */
    public int getOldTemperature() {
        return oldTemperature;
    }
    
    /** Setter for property oldTemperature.
     * @param oldTemperature New value of property oldTemperature.
     */
    public void setOldTemperature(int oldTemperature) {
        this.oldTemperature = oldTemperature;
    }
    
}
