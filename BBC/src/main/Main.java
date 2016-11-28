package main;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

import com.app.Domain;
import com.app.Editor;
import com.app.News;
import com.app.Reader;
import com.app.event.AppearEvent;
import com.app.event.DeletionEvent;
import com.app.event.ReadNewsEvent;
import com.app.event.UpdateEvent;
import com.event.EventRouter;
import com.event.Event;
public class Main {
	public static void main(String argv[])
	{
	    EventRouter dispatcher = new EventRouter();
	    
	    Queue<Event> eventsGenerated = new LinkedList<Event>();
	    Reader r0 = new Reader("Eminescu", eventsGenerated);
	    Reader r1 = new Reader("Veronica", eventsGenerated);
	    
	    r0.addNewsFilter(Domain.SPORT);
	    r0.addNewsFilter(Domain.BREXIT);
	    r1.addNewsFilter(Domain.SPORT);
	    
	    Editor e = new Editor("Sun Tzu", eventsGenerated);
	    dispatcher.registerListener(AppearEvent.class,r0);
	    dispatcher.registerListener(UpdateEvent.class, r0);
	    dispatcher.registerListener(DeletionEvent.class, r0);
	    
	    dispatcher.registerListener(AppearEvent.class,r1);
	    dispatcher.registerListener(UpdateEvent.class, r1);
	    dispatcher.registerListener(DeletionEvent.class, r1);

	    
	    dispatcher.registerListener(ReadNewsEvent.class, e);
	    
	    e.appearNews(new News("Becali is on the stage", Domain.SPORT, "Ionescu", "XXX", new Date(), new Date()));
	    e.appearNews(new News("Mutu trage iar pe nas", Domain.SPORT, "Videsuc", "Xff", new Date(), new Date()));
	    e.appearNews(new News("Trump is winning the election in Moscow", Domain.BREXIT, "Trump", "Wtf", new Date(), new Date()));
	   
	    e.updateNews(new News("Trump is losing the election in Moscow", Domain.BREXIT, "Trump", "Wtf", new Date(), new Date()));
	    r0.imReadingNews();
	    r0.imReadingNews();
	    e.deletionNews(new News("Title1", Domain.SPORT, "MeXme", "XXX", new Date(), new Date()));
	    
	    
	    while (!eventsGenerated.isEmpty()) {
	        Event evt = eventsGenerated.remove();
	        dispatcher.dispatch(evt);
	      }
	    
	    
		
	}
}
