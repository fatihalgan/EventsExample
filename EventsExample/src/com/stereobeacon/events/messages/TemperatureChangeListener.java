/*
 * TemperatureChangeListener.java
 *
 * Created on January 2, 2002, 7:34 PM
 */

package com.stereobeacon.events.messages;

/**
 *
 * @author  default
 * @version 
 */
public interface TemperatureChangeListener extends java.util.EventListener {

    public void updateTemperature(TemperatureChangeEvent evt);
    
}

