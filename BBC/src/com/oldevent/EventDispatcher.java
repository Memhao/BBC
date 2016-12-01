package com.oldevent;
/**
 * La Dispatcher se pot inregistra clase interesate de anumite tipuri de evenimente
 * Adica listen-eri
 * @author xander
 *
 */
public interface EventDispatcher {
	void registerListener(Class<? extends Event> event,Listener listener);
	void dispatch(Event event);
}
