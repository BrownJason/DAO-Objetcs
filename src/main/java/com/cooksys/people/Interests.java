package com.cooksys.people;

public class Interests {
	private Integer id;
	private String title;
	
	public Interests() {
		
	}
	
	public Interests(Integer id) {
		super();
		this.id = id;
	}
	
	public Interests(String title) {
		super();
		this.title = title;
	}
	
	public Interests(Integer id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "Interests [id=" + id + ", title=" + title + "]";
	}

}
