/*
 * IndoorTemperature.java
 *
 * Created on January 2, 2002, 7:28 PM
 */

package com.stereobeacon.events.topical;

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
public class DownstairsTemperature extends TemperatureGaugeImpl {

    /** Creates new IndoorTemperature */
    public DownstairsTemperature() throws RemoteException {
            super();
    }

    public int getMaximum(){
        return 65;
    }
    public int getMinimum(){
        return 60;
    }
    public String getLocation(){
        return "Downstairs";
    }
}
