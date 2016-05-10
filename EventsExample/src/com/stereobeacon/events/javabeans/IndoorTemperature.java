/*
 * IndoorTemperature.java
 *
 * Created on January 1, 2002, 8:18 PM
 */

package com.stereobeacon.events.javabeans;

import java.beans.*;
import com.pe.mp3request.util.Monitor;

/**
 *
 * @author  default
 * @version 
 */
public class IndoorTemperature extends Object implements java.io.Serializable {

    private PropertyChangeSupport propertySupport;
    private static final boolean debug = true;

    /** Holds value of property temperature. */
    private int temperature;
    
    /** Creates new IndoorTemperature */
    public IndoorTemperature() {
        propertySupport = new PropertyChangeSupport ( this );
        
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


    public void addPropertyChangeListener (PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener (listener);
    }

    public void removePropertyChangeListener (PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener (listener);
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
        int oldTemperature = this.temperature;
        this.temperature = temperature;
        if(debug) System.out.println("INFO::IndoorTemperature::setTemperature "+temperature);
        propertySupport.firePropertyChange("temperature", new Integer(oldTemperature), new Integer(temperature));
    }
    
}
