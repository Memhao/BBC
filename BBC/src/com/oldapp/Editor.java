package com.oldapp;

import java.util.Queue;

import com.oldapp.event.AppearEvent;
import com.oldapp.event.DeletionEvent;
import com.oldapp.event.EventType;
import com.oldapp.event.UpdateEvent;
import com.oldevent.Event;
/**
 * Acts like an event generator 
 * @author xander
 *
 */
public class Editor implements User{
	private Queue<Event> eventsGenerated;
	private String name;
	private int noOfReaders;
	public Editor(String name,Queue<Event> eventsGenerated2)
	{
		this.noOfReaders = 0;
		this.name = name;
		this.eventsGenerated = eventsGenerated2;
	}
	

	
	/**
	 * Event generator method
	 * @param news
	 */
	public void appearNews(News news)
	{
		eventsGenerated.add(new AppearEvent(this,news));
	}
	/**
	 * Event generator method
	 * @param news
	 */
	public void deletionNews(News news)
	{
		eventsGenerated.add(new DeletionEvent(this, news));
	}
	/**
	 * Event generator method
	 * @param news
	 */
	public void updateNews(News news)
	{
		eventsGenerated.add(new UpdateEvent(this,news));
	}
	
	public String toString()
	{
		return this.name;
	}



	@Override
	public void dispatch(Event event) {
		if(event.getType().equals(EventType.READ.toString()))
		{
			noOfReaders++;
			System.out.println(this.name + ":"+noOfReaders+" is reading my news");
		}
	}
}
