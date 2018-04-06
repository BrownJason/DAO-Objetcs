package com.cooksys.people;

import java.util.Set;

public class Peoples {
	private Integer id;
	private String firstName;
	private String lastName;
	private Integer age;
	private Integer interestid;
	private Locations locations;
	private Set<Interests> interests;
	
	public Peoples() {
		
	}
	
	public Peoples(Integer id) {
		super();
		this.id = id;
	}
	
	public Peoples(Integer id, String firstName, String lastName, Integer age, Integer interestid) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.interestid = interestid;
	}

	public Peoples(Integer id, String firstName, String lastName, Integer age, Integer interestid, Locations locations,
			Set<Interests> interests) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.interestid = interestid;
		this.locations = locations;
		this.interests = interests;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Locations getLocations() {
		return locations;
	}

	public void setLocations(Locations locations) {
		this.locations = locations;
	}

	public Set<Interests> getInterests() {
		return interests;
	}

	public void setInterests(Set<Interests> interests) {
		this.interests = interests;
	}
	
	public Integer getInterestid() {
		return interestid;
	}

	public void setInterestid(Integer interestid) {
		this.interestid = interestid;
	}

	@Override
	public String toString() {
		return "Peoples [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", interest_id=" + interestid + ", locations=" + locations + ", interests=" + interests + "]";
	}
	
}
