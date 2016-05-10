/*
 * EventServiceImpl.java
 *
 * Created on January 2, 2002, 8:45 PM
 */

package com.stereobeacon.events.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author  default
 * @version 
 */
public interface EventService extends Remote {            

    /** Registers TemperatureChangeListener to receive events.
     * @param listener The listener to register.
     */
    public void addTemperatureChangeListener(
        TemperatureChangeListener listener) 
        throws RemoteException;
    
    /** Removes TemperatureChangeListener from the list of listeners.
     * @param listener The listener to remove.
     */
    public void removeTemperatureChangeListener(
        TemperatureChangeListener listener)
        throws RemoteException;
    
    /** Notifies all registered listeners about the event.
     *
     * @param e The event to be fired
     */
    public void fireTemperatureChangeEvent(
        TemperatureChangeEvent event) 
        throws RemoteException;
    
}
