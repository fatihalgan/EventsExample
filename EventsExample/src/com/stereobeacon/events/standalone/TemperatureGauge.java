/*
 * IndoorTemperature.java
 *
 * Created on January 2, 2002, 7:28 PM
 */

package com.stereobeacon.events.standalone;

import java.beans.*;
import javax.swing.event.EventListenerList;
import java.util.EventListener;
import com.pe.mp3request.util.Monitor;

/**
 *
 * @author  default
 * @version 
 */
public abstract class TemperatureGauge extends Object implements java.io.Serializable {

    /** Holds value of property temperature. */
    private int temperature = 64;
        
    private static final boolean debug = true;

    /** Creates new IndoorTemperature */
    public TemperatureGauge() {
        new Thread(new Runnable(){
            Monitor m = new Monitor();
            public void run(){
                boolean increment=false;
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
                
            }
        }
        
        ).start();
    }


    /** Getter for property temperature.
     * @return Value of property temperature.
     */
    public int getTemperature() {
        return temperature;
    }
    
    /** Setter for property temperature.
     * @param temperature New value of property temperature.
     */
    public void setTemperature(int temperature) {
        if(debug) System.out.println("INFO::"+getClass().getName()+"::setTemperature "+temperature);
        TemperatureChangeEvent tce = new TemperatureChangeEvent(this, getLocation(), this.temperature, temperature);
        this.temperature = temperature;
        EventServiceImpl.getEventService().fireTemperatureChangeEvent(tce);
    }
    
    public abstract int getMaximum();
    public abstract int getMinimum();
    public abstract String getLocation();
}
