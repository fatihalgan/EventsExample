/*
 * EventServiceImpl.java
 *
 * Created on January 2, 2002, 8:45 PM
 */

package com.stereobeacon.events.standalone;

/**
 *
 * @author  default
 * @version 
 */
public class EventServiceImpl {

    /** Utility field used by event firing mechanism. */
    private javax.swing.event.EventListenerList listenerList =  null;
    
    private static EventServiceImpl service = null;
    
    /** Creates new EventServiceImpl */
    private EventServiceImpl() {
    }
    
    public static EventServiceImpl getEventService(){
        if(service==null){
            service = new EventServiceImpl();
        }
        
        return service;
    }
            

    /** Registers TemperatureChangeListener to receive events.
     * @param listener The listener to register.
     */
    public synchronized void addTemperatureChangeListener(com.stereobeacon.events.standalone.TemperatureChangeListener listener) {
        if (listenerList == null ) {
            listenerList = new javax.swing.event.EventListenerList();
        }
        listenerList.add(com.stereobeacon.events.standalone.TemperatureChangeListener.class, listener);
    }
    
    /** Removes TemperatureChangeListener from the list of listeners.
     * @param listener The listener to remove.
     */
    public synchronized void removeTemperatureChangeListener(com.stereobeacon.events.standalone.TemperatureChangeListener listener) {
        listenerList.remove(com.stereobeacon.events.standalone.TemperatureChangeListener.class, listener);
    }
    
    /** Notifies all registered listeners about the event.
     *
     * @param e The event to be fired
     */
    public void fireTemperatureChangeEvent(TemperatureChangeEvent event) {
        if (listenerList == null) return;
        Object[] listeners = listenerList.getListeners(TemperatureChangeListener.class);
        for (int i = 0 ; i<listeners.length; i++) {
            ((TemperatureChangeListener)listeners[i]).updateTemperature(event);
        }
    }
    
}
