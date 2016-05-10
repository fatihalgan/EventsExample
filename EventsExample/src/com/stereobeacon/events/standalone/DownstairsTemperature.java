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
public class DownstairsTemperature extends TemperatureGauge {

    /** Creates new IndoorTemperature */
    public DownstairsTemperature() {
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
