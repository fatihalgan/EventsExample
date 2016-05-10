/*
 * TemperatureChangeEvent.java
 *
 * Created on January 2, 2002, 7:31 PM
 */

package com.stereobeacon.events.topical;
import java.util.*;
/**
 *
 * @author  default
 * @version 
 */
public class TopicEvent extends java.util.EventObject {

    /** Holds value of property newTemperature. */
    private String topic = null;
    /** Holds value of property oldTemperature. */
    private Hashtable data = null;
    
    /** Creates new TemperatureChangeEvent */
    public TopicEvent(Object source, String topic, Hashtable data){
        super(source);
        this.topic = topic;
        this.data = data;
    }
    
    /** 
     * @return topic of the event
     */
    public String getTopic() {
        return topic;
    }
    
    /** 
     */
    public Hashtable getData(){
        return data;
    }
}
