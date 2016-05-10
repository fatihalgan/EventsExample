/*
 * Thermostat.java
 *
 * Created on January 1, 2002, 4:48 PM
 */

package com.stereobeacon.events.topical;

import java.util.Vector;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author  pmonday@stereobeacon.com
 * @version 1.0
 */
public interface Thermostat extends Remote {
    
    /** Getter for property heater.
     * @return Value of property heater.
     */
    public boolean isHeater() throws RemoteException;
    
    /** Setter for property heater.
     * @param heater New value of property heater.
     */
    public void setHeater(boolean heater) throws RemoteException;
       
}
