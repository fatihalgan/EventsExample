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
public class StartEventService {
    public static final int REGISTRY_PORT = Registry.REGISTRY_PORT;
    public static final boolean debug = true;
    /** Creates new Test */
    public StartEventService() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
         if(debug) System.out.println("Creating registry...");
         try {
             LocateRegistry.createRegistry(REGISTRY_PORT);
         } catch(RemoteException re){
             re.printStackTrace();
         }

         if(debug) System.out.println("Main::Retrieving the event service");
         try {
             EventService es = EventServiceImpl.getEventService();
             if(debug) System.out.println("Main::Binding event service to registry");
             Naming.bind("EventService",es);
         } catch(RemoteException re){
             re.printStackTrace();
         } catch(Exception e){
             e.printStackTrace();
         }
             

        
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
