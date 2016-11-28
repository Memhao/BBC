package com.app;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

import com.app.event.AppearEvent;
import com.app.event.DeletionEvent;
import com.app.event.ReadNewsEvent;
import com.app.event.UpdateEvent;
import com.event.Event;

public class Reader implements User{
	private String name; 
	private Queue<Event> eventsGenerated;
	private Set<Domain> targetDomains; 
	public Reader(String name, Queue<Event> eventsGenerated2) {
		this.name = name;
		this.eventsGenerated = eventsGenerated2;
		this.targetDomains = new HashSet<Domain>();
	}
	
	public void addNewsFilter(Domain filter)
	{	
		this.targetDomains.add(filter);
	}
	
	
	
	/**
	 * Show the behavior of Reader when an event occurs
	 */
	@Override
	public void dispatch(Event event) {
		switch (event.getType()) {
		case "APPEARS":
		
			AppearEvent apperevent = (AppearEvent)event;
			if(targetDomains.size()>0)
				for(Domain domain : targetDomains)
				{
					if(apperevent.getNews().getDomain().equals(domain))
					{
						System.out.print("New info available for =>");
						System.out.println(this.name+": got fresh news : "+ apperevent.getNews().getDomain()+"["+apperevent.getNews().getTitle()+"]");
						System.out.println();
					}
				}
			

			
			break;
		case "UPDATE":
			UpdateEvent updateevent = (UpdateEvent)event;
			if(targetDomains.size()>0)
				for(Domain domain : targetDomains)
				{
					if(updateevent.getNews().getDomain().equals(domain))
					{
						System.out.print("Updated info available for =>");
						System.out.println(this.name+": got fresh news : "+ updateevent.getNews().getDomain()+"["+updateevent.getNews().getTitle()+"]" + updateevent.getNews().getLastModifDate());
						System.out.println();
					}
				}
			break;
		case "DELETED":
			DeletionEvent deletionEvent = (DeletionEvent)event;
			if(targetDomains.size()>0)
				for(Domain domain : targetDomains)
				{
					if(deletionEvent.getNews().getDomain().equals(domain))
					{
						System.out.print("Deleted news for =>");
						System.out.println(this.name+": "+ deletionEvent.getNews().getDomain()+"["+deletionEvent.getNews().getTitle()+"]" + "has been deleted");
						System.out.println();
					}
				}
			break;
		default:
			System.out.println("No modif ");
			break;
		}
	}
	
	/**
	 * Event generator method
	 * @param news
	 */
	public void imReadingNews()
	{
		eventsGenerated.add(new ReadNewsEvent());
	}
	@Override
	public String toString() {
		return "Reader [name=" + name + "]";
	}
	

}
