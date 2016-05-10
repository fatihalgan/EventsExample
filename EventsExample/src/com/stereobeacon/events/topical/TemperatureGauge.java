/*
 * IndoorTemperature.java
 *
 * Created on January 2, 2002, 7:28 PM
 */

package com.stereobeacon.events.topical;

import java.beans.*;
import javax.swing.event.EventListenerList;
import java.util.EventListener;
import com.pe.mp3request.util.Monitor;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author  default
 * @version 
 */
public interface TemperatureGauge extends Remote, java.io.Serializable {
    public static final String CHANGE_EVENT_TOPIC = ".temperature.change";
    public static final String LOCATION_KEY = "location";
    public static final String NEWTEMP_KEY = "new temperature";
    public static final String OLDTEMP_KEY = "old temperature";
    /** Getter for property temperature.
     * @return Value of property temperature.
     */
    public int getTemperature() throws RemoteException;
    
    /** Setter for property temperature.
     * @param temperature New value of property temperature.
     */
    public void setTemperature(int temperature)  throws RemoteException;

    public void setEventService(EventService eventService) throws RemoteException;
}
