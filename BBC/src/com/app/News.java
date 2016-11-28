package com.app;

import java.util.Date;

public class News {
	private String title;
	private Domain domain;
	private String author;
	private String source;
	private Date firstIssue;
	private Date lastModifDate;
	
	
	
	public News(String title, Domain domain, String author, String source, Date firstIssue, Date lastModifDate) {
		super();
		this.title = title;
		this.domain = domain;
		this.author = author;
		this.source = source;
		this.firstIssue = firstIssue;
		this.lastModifDate = lastModifDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Domain getDomain() {
		return domain;
	}
	public void setDomain(Domain domain) {
		this.domain = domain;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Date getFirstIssue() {
		return firstIssue;
	}
	public void setFirstIssue(Date firstIssue) {
		this.firstIssue = firstIssue;
	}
	public Date getLastModifDate() {
		return lastModifDate;
	}
	public void setLastModifDate(Date lastModifDate) {
		this.lastModifDate = lastModifDate;
	}
	
	
	
}
