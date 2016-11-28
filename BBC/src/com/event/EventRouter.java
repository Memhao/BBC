package com.event;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/**
 * 
 * @author xander
 *	An event may be handled by multiple listeners
 *	Or a class may be interested in many events
 */
public class EventRouter implements EventDispatcher {
	private Map<Class<? extends Event>, HashSet<Listener>> listeners = new HashMap<Class<? extends Event>, HashSet<Listener>>();
	@Override
	public void registerListener(Class<? extends Event> event, Listener listener) {
		if(this.listeners.get(event) == null)
		{
			this.listeners.put(event, new HashSet<Listener>());
		}
		this.listeners.get(event).add(listener);
	}
	
	@Override
	public void dispatch(Event event) {
		HashSet<Listener> set = listeners.get(event.getClass());
		if(set!=null)
		for(Listener listener : set)
		{
			listener.dispatch(event);
		}
		
	}

}
