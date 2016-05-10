/*
 * Thermostat.java
 *
 * Created on January 1, 2002, 4:48 PM
 */

package com.stereobeacon.events.topical;

import java.util.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author  pmonday@stereobeacon.com
 * @version 1.0
 */
public class ThermostatImpl extends UnicastRemoteObject 
    implements TopicEventListener, Thermostat {
    
    /** Holds value of property heater. */
    private boolean heater;
    
    private static final boolean debug = true;

    private Vector coldRooms = new Vector(2);
    
    /** Creates new Thermostat */
    public ThermostatImpl() throws RemoteException {
    }
    
    /** Getter for property heater.
     * @return Value of property heater.
     */
    public boolean isHeater() throws RemoteException {
        return heater;
    }
    
    /** Setter for property heater.
     * @param heater New value of property heater.
     */
    public void setHeater(boolean heater)  throws RemoteException {
        if(heater != this.heater){
            if(debug) System.out.println("INFO::Thermostat::setHeater "+heater);
            this.heater = heater;
        }
    }
    
    public void notify(TopicEvent event)  throws RemoteException {
        String topic = event.getTopic();
        if(topic.equals(TemperatureGauge.CHANGE_EVENT_TOPIC)){
            Hashtable data = event.getData();
            String location = (String)data.get(TemperatureGauge.LOCATION_KEY);
            int newTemp = ((Integer)data.get(TemperatureGauge.NEWTEMP_KEY)).intValue();
            
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
    
}
