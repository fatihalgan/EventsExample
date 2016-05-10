/*
 * EventServiceImpl.java
 *
 * Created on January 2, 2002, 8:45 PM
 */

package com.stereobeacon.events.topical;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.*;

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
    
    private Hashtable listeners = new Hashtable(1);
    
    private static EventServiceImpl service = null;
    
    private static final boolean debug = true;
    
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
    public synchronized void addListener(String topic, 
        TopicEventListener listener) 
        throws RemoteException
    {
        if(debug) System.out.println("EventServiceImpl::addListener "+topic);
        Vector list = null;
        if(!listeners.containsKey(topic)){
            list = new Vector(1);
        } else {
            list = (Vector)listeners.get(topic);
            listeners.remove(topic);
        }
        list.add(listener);
        listeners.put(topic, list);
    }
    
    /** Removes a listener from the list of listeners.
     * @param listener The listener to remove.
     */
    public synchronized void removeListener(String topic,
        TopicEventListener listener) 
        throws RemoteException
    {
        Vector list = null;
        if(listeners.containsKey(topic)){
            list = (Vector)listeners.get(topic);
            listeners.remove(topic);
            list.remove(listener);
            if(list.size()>0)
                listeners.put(topic, list);
        }
    }
    
    /** Notifies all registered listeners about the event.
     *
     * @param e The event to be fired
     */
    public void fireEvent(TopicEvent event) 
        throws RemoteException
    {
        if(debug) System.out.println("EventServiceImpl::fireEvent "+event.getTopic());
        Vector list = null;
        if(listeners.containsKey(event.getTopic())){
            list = (Vector)listeners.get(event.getTopic());
            Enumeration e = list.elements();
            while(e.hasMoreElements()){
                TopicEventListener tel = (TopicEventListener)e.nextElement();
                tel.notify(event);
            }
        }
    }
    
}
