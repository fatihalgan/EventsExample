/*
 * EventServiceImpl.java
 *
 * Created on January 2, 2002, 8:45 PM
 */

package com.stereobeacon.events.remote;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
/**
 *
 * @author  pmonday@stereobeacon.com
 * @version 1.0
 */
public class EventServiceImpl extends UnicastRemoteObject 
    implements EventService 
{

    /** Utility field used by event firing mechanism. */
    private javax.swing.event.EventListenerList listenerList =  null;
    
    private static EventServiceImpl service = null;
    
    private EventServiceImpl() throws RemoteException {
    }
    
    public static EventServiceImpl getEventService() throws RemoteException {
        if(service==null){
            service = new EventServiceImpl();
        }
        
        return service;
    }
            

    /** Registers TemperatureChangeListener to receive events.
     * @param listener The listener to register.
     */
    public synchronized void addTemperatureChangeListener(
        TemperatureChangeListener listener) 
        throws RemoteException
    {
        if (listenerList == null ) {
            listenerList = new javax.swing.event.EventListenerList();
        }
        listenerList.add(TemperatureChangeListener.class, listener);
    }
    
    /** Removes TemperatureChangeListener from the list of listeners.
     * @param listener The listener to remove.
     */
    public synchronized void removeTemperatureChangeListener(
        TemperatureChangeListener listener) throws RemoteException
    {
        listenerList.remove(TemperatureChangeListener.class, listener);
    }
    
    /** Notifies all registered listeners about the event.
     *
     * @param e The event to be fired
     */
    public void fireTemperatureChangeEvent(
        TemperatureChangeEvent event) throws RemoteException
    {
        if (listenerList == null) return;
        Object[] listeners = listenerList.getListeners(TemperatureChangeListener.class);
        for (int i = 0 ; i<listeners.length; i++) {
            ((TemperatureChangeListener)listeners[i]).updateTemperature(event);
        }
    }
    
}
