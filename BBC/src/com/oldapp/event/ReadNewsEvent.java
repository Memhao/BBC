package com.oldapp.event;

import com.oldevent.Event;

/**
 * The editors are interested in this kind of event to know 
 * how many readers they have
 * @author xander
 *
 */
public class ReadNewsEvent implements Event{

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return EventType.READ.toString();
	}

}
