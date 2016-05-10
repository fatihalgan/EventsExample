/*
 * TemperatureChangeListener.java
 *
 * Created on January 2, 2002, 7:34 PM
 */

package com.stereobeacon.events.remote;

import java.rmi.RemoteException;
/**
 *
 * @author  default
 * @version 
 */
public interface TemperatureChangeListener extends java.util.EventListener, java.rmi.Remote {

    public void updateTemperature(TemperatureChangeEvent evt) throws RemoteException;
    
}

