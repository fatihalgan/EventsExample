/*
 * TemperatureChangeListener.java
 *
 * Created on January 2, 2002, 7:34 PM
 */

package com.stereobeacon.events.topical;

import java.rmi.RemoteException;
/**
 *
 * @author  default
 * @version 
 */
public interface TopicEventListener extends java.util.EventListener, java.rmi.Remote {

    public void notify(TopicEvent evt) throws RemoteException;
    
}

