/*
 * IndoorTemperature.java
 *
 * Created on January 2, 2002, 7:28 PM
 */

package com.stereobeacon.events.remote;

import java.beans.*;
import javax.swing.event.EventListenerList;
import java.util.EventListener;
import com.pe.mp3request.util.Monitor;
import java.rmi.*;
import java.rmi.server.*;
/**
 *
 * @author  default
 * @version
 */
public abstract class TemperatureGaugeImpl extends UnicastRemoteObject implements TemperatureGauge {
    
    /** Holds value of property temperature. */
    private int temperature = 64;
    
    private static final boolean debug = true;
    
    private EventService eventService = null;
    
    /** Creates new IndoorTemperature */
    public TemperatureGaugeImpl() throws RemoteException {
        new Thread(new Runnable(){
            Monitor m = new Monitor();
            public void run(){
                boolean increment=false;
                try {
                    int max=getMaximum();
                    int min=getMinimum();
                    int cur=getTemperature();
                    while(true){
                        if(increment) cur++;
                        else cur--;
                        setTemperature(cur);
                        if(cur==min) increment = true;
                        else if(cur==max) increment=false;
                        m.block(1000);
                    }
                } catch(RemoteException re){
                }
                
            }
        }
        
        ).start();
    }
    
    
    /** Getter for property temperature.
     * @return Value of property temperature.
     */
    public int getTemperature() throws RemoteException {
        return temperature;
    }
    
    /** Setter for property temperature.
     * @param temperature New value of property temperature.
     */
    public void setTemperature(int temperature) throws RemoteException {
        if(debug) System.out.println("INFO::"+getClass().getName()+"::setTemperature "+temperature);
        TemperatureChangeEvent tce = new TemperatureChangeEvent(this, getLocation(), this.temperature, temperature);
        this.temperature = temperature;
        try {
            if(eventService != null)
                eventService.fireTemperatureChangeEvent(tce);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void setEventService(EventService eventService) throws RemoteException {
        this.eventService = eventService;
    }
    
    protected abstract int getMaximum();
    protected abstract int getMinimum();
    protected abstract String getLocation();
}
