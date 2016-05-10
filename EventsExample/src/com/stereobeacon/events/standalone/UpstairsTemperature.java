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
public class UpstairsTemperature extends TemperatureGauge {

    /** Creates new IndoorTemperature */
    public UpstairsTemperature() {
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
