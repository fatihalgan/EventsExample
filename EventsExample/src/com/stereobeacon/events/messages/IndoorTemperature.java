/*
 * IndoorTemperature.java
 *
 * Created on January 2, 2002, 7:28 PM
 */

package com.stereobeacon.events.messages;

import java.beans.*;
import javax.swing.event.EventListenerList;
import java.util.EventListener;
import com.pe.mp3request.util.Monitor;

/**
 *
 * @author  default
 * @version 
 */
public class IndoorTemperature extends Object implements java.io.Serializable {

    /** Holds value of property temperature. */
    private int temperature;
        
    /** Utility field used by event firing mechanism. */
    private EventListenerList listenerList =  null;
    
    private static final boolean debug = true;

    /** Creates new IndoorTemperature */
    public IndoorTemperature() {
        new Thread(new Runnable(){
            Monitor m = new Monitor();
            public void run(){
                boolean increment=false;
                int max=67;
                int min=62;
                int cur=67;
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
        if(debug) System.out.println("INFO::IndoorTemperature::setTemperature "+temperature);
        fireTemperatureChangeEvent(this.temperature, temperature);
        this.temperature = temperature;
    }
    
    protected synchronized void fireTemperatureChangeEvent(int oldTemp, int newTemp){
        TemperatureChangeEvent tce = new TemperatureChangeEvent(this, oldTemp, newTemp);
        EventListener[] list = listenerList.getListeners(TemperatureChangeListener.class);
        for(int i=0 ; i<list.length ; i++){
            TemperatureChangeListener tcl = (TemperatureChangeListener)list[i];
            tcl.updateTemperature(tce);
        }
    }
    
    /** Registers TemperatureChangeListener to receive events.
     * @param listener The listener to register.
     */
    public synchronized void addTemperatureChangeListener(com.stereobeacon.events.messages.TemperatureChangeListener listener) {
        if (listenerList == null ) {
            listenerList = new javax.swing.event.EventListenerList();
        }
        listenerList.add(com.stereobeacon.events.messages.TemperatureChangeListener.class, listener);
    }
    
    /** Removes TemperatureChangeListener from the list of listeners.
     * @param listener The listener to remove.
     */
    public synchronized void removeTemperatureChangeListener(com.stereobeacon.events.messages.TemperatureChangeListener listener) {
        listenerList.remove(com.stereobeacon.events.messages.TemperatureChangeListener.class, listener);
    }
    
}
