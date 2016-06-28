package com.ibm.bluemix.catalogm.community;

public class Discussion {
	
	private String id;
	private String title;
	private String link;
	private int rank;
	private String author;
	private String summary;
	private String publishDate;
	private String updateDate;
	
	public String getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getLink() {
		return link;
	}
	
	public int getRank() {
		return rank;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getSummary() {
		return summary;
	}
	
	public String getPublishDate() {
		return publishDate;
	}
	
	public String getUpdateDate() {
		return updateDate;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}	
	
}