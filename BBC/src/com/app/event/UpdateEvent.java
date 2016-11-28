package com.app.event;


import com.app.Editor;
import com.app.News;
import com.event.Event;

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
