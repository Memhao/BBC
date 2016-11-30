package com.api.event;

public interface IDispatcher {
	
	/**
	 * Subscribe listeners for events that are strained by a filter
	 * @param evenType what kind of events a listener are interested in 
	 * @param filter what events a listener are registered 
	 * in other words a class may register(listen) for more events
	 * @param listener is class that are interested in events specified by filter
	 */
	public void subscribeListener(Class<? extends IEvent> eventType,IFilter filter,IListener listener);
	
	
	/**
	 * Unsubscribe a listener if it is no longer interested in listening for certain events
	 * @param eventType what kind of events a listener are interested in 
	 * @param filter what events a listener are registered 
	 * @param listener is class that are interested in events specified by filter
	 */
	
	public void unsubscribeListener(Class<? extends IEvent> eventType, IFilter filter, IListener listener);
	/**
	 * Listeners received events in which they are interested in via filters
	 * @param event to be dispatch accordingly to its filter and listeners
	 */
	public void publish(Class<? extends IEvent> event);
	
}
