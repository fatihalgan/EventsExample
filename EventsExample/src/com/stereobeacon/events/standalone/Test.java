/*
 * Test.java
 *
 * Created on January 1, 2002, 4:55 PM
 */

package com.stereobeacon.events.standalone;

/**
 *
 * @author  default
 * @version
 */
public class Test {
    
    /** Creates new Test */
    public Test() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // Create a new Observable
        TemperatureGauge up = new UpstairsTemperature();
        TemperatureGauge down = new DownstairsTemperature();
        
        // Create a new Observer
        Thermostat t = new Thermostat();
        
        // Register the Observer with the Observable
        EventServiceImpl.getEventService().addTemperatureChangeListener(t);
        
        // Run until interrupted by blocking indefinately
        Object o = new Object();
        synchronized(o){
            try {
                o.wait();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        
        
    }
    
}
