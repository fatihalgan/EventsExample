/*
 * IndoorTemperature.java
 *
 * Created on January 1, 2002, 4:43 PM
 */

package com.stereobeacon.events.observer;
import com.pe.mp3request.util.Monitor;

/**
 * A simple example of the observer pattern for event notification.
 * @author  pmonday@stereobeacon.com
 * @version 1.0
 */
public class IndoorTemperature extends java.util.Observable {
    
    /** Holds value of property temperature. */
    private int temperature;
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
        if(this.temperature != temperature){
            if(debug) System.out.println(
                "INFO::IndoorTemperature::setTemperature "
                +temperature);
            this.temperature = temperature;
            setChanged();
            
        }
        notifyObservers();
    }
}
