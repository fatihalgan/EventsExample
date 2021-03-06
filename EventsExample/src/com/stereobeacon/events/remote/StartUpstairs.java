/*
 * Test.java
 *
 * Created on January 1, 2002, 4:55 PM
 */

package com.stereobeacon.events.remote;
import java.rmi.registry.*;
import java.rmi.RemoteException;
import java.rmi.Naming;

/**
 *
 * @author  default
 * @version
 */
public class StartUpstairs {
   
    /** Creates new Test */
    public StartUpstairs() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // Create a new Observable
        
        try {
            TemperatureGauge up = new UpstairsTemperature();
            TemperatureGauge down = new DownstairsTemperature();
            EventService remoteService = null;
            String rmiServer = "rmi://"+args[0]+":"+StartEventService.REGISTRY_PORT+"/EventService";
            remoteService = (EventService)Naming.lookup(rmiServer);
            up.setEventService(remoteService);
            down.setEventService(remoteService);
            // Run until interrupted by blocking indefinately
            Object o = new Object();
            synchronized(o){
                try {
                    o.wait();
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        } catch(Exception nbe){
            nbe.printStackTrace();
        }
                
    }
    
}
