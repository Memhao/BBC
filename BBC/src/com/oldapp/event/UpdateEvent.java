package com.oldapp.event;


import com.oldapp.Editor;
import com.oldapp.News;
import com.oldevent.Event;

public class UpdateEvent implements Event{

	private Editor editor;
	private News news;
	
	
	public UpdateEvent(Editor editor, News news) {
		this.editor = editor;
		this.news = news;
	}
	public Editor getEditor()
	{
		return editor;
	}
	public News getNews()
	{
		return news;
	}
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return EventType.UPDATE.toString();
	}

}
