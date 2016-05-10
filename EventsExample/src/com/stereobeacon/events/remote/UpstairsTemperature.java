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
import java.rmi.RemoteException;
/**
 *
 * @author  default
 * @version 
 */
public class UpstairsTemperature extends TemperatureGaugeImpl {

    /** Creates new IndoorTemperature */
    public UpstairsTemperature() throws RemoteException{
            super();
    }

    public int getMaximum(){
        return 68;
    }
    public int getMinimum(){
        return 62;
    }
    public String getLocation(){
        return "Upstairs";
    }
}
