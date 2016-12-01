package com.oldapp.event;

import com.oldapp.Editor;
import com.oldapp.News;
import com.oldevent.Event;

public class DeletionEvent implements Event{

	private Editor editor;
	private News news;
	
	public DeletionEvent(Editor editor, News news) {
		this.editor = editor;
		this.news = news;
	}
	public News getNews()
	{
		return news;
	}
	public Editor getEditor()
	{
		return editor;
	}
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return EventType.DELETED.toString();
	}

}
