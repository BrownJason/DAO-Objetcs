package com.cooksys.people;

public class Locations {
	private Integer id;
	private String city;
	private String state;
	private String country;
	private Integer person_id;
	
	public Locations() {
		
	}
	
	public Locations(Integer id) {
		super();
		this.id = id;
	}
	
	public Locations(String state) {
		super();
		this.state = state;
	}
	
	public Locations(Integer id, String city, String state, String country, Integer person_id) {
		super();
		this.id = id;
		this.city = city;
		this.state = state;
		this.country = country;
		this.person_id = person_id;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String county) {
		this.country = county;
	}
	public Integer getPerson_id() {
		return person_id;
	}
	public void setPerson_id(Integer person_id) {
		this.person_id = person_id;
	}
	
	@Override
	public String toString() {
		return "Locations [id=" + id + ", city=" + city + ", state=" + state + ", county=" + country + ", person_id="
				+ person_id + "]";
	}
	
}
