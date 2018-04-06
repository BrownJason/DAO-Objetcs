package com.cooksys.people;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PeoplesDao {
	
	public static List<Peoples> getPeopleId(Integer id){
		ResultSet results = ConnectionManager.executeQuery("SELECT * FROM person WHERE id ='" + id + "'");
		
		ArrayList<Peoples> people = new ArrayList<Peoples>();
		
		try {
				while(results.next()){
				Locations local = new Locations(LocationDao.getLocationId(id).get(0).getId(), LocationDao.getLocationId(id).get(0).getCity(), LocationDao.getLocationId(id).get(0).getState(), LocationDao.getLocationId(id).get(0).getCountry(), LocationDao.getLocationId(id).get(0).getPerson_id());
				
				Set<Interests> interests = new HashSet<Interests>();
				Interests interest = new Interests(InterestDao.getInterestId(results.getInt(5)).get(0).getId(), InterestDao.getInterestId(id).get(0).getTitle());
				interests.add(interest);
				
				people.add(new Peoples(results.getInt(1), results.getString(2), results.getString(3), results.getInt(4), results.getInt(5), local, interests));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return people;
	}
	
	public static void savePeople(Peoples people) {

		int size = 0;
		ResultSet ress = ConnectionManager.executeQuery("SELECT * FROM person");
		
		try {
			if(ress != null) {
				ress.last();
				size = ress.getRow();
			}
			
			if (people.getId() != null && people.getId() <= (size+1)){
				String sqlUpdate = "UPDATE person SET firstname='" + people.getFirstName() + "', lastname='" + people.getLastName() + 
						"', age='" + people.getAge() + "', interest_id='"+ people.getInterestid() + "' WHERE id=" + people.getId() +";";
				
				ConnectionManager.executeUpdate(sqlUpdate);
				
				String localUpdate = "UPDATE locations SET city='" + people.getLocations().getCity()  
						+ "', state='" + people.getLocations().getState() + "', "
						+ "country='" + people.getLocations().getCountry() + "', "
						+ "person_id='" + people.getLocations().getPerson_id() + "', "
						+ "WHERE location_id=" + people.getLocations().getId() + ";";
				
				ConnectionManager.executeUpdate(localUpdate);
				
				Interests ints = new Interests();
				ints.getId();
				ints.getTitle();
				people.getInterests().add(ints);
				
				String interestUpdate = "UPDATE interest SET title='" + new Interests(ints.getTitle()) + "' WHERE id=" + new Interests(ints.getId()) + ";";
				
				ConnectionManager.executeUpdate(interestUpdate);

			} else if (people.getId() == null) {
				String sqlInsert = "INSERT INTO person VALUES (" + ress.getRow() +", "
						+ "'" + people.getFirstName() + "', '" + people.getLastName() + "', "
								+ "" + people.getAge() +", " + people.getInterestid() + ")";
			
				ConnectionManager.executeUpdate(sqlInsert);
				
				String localInsert = "INSERT INTO locations VALUES (" + ress.getRow() +", "
						+ "'" + people.getLocations().getCity() + "', '" + people.getLocations().getState() + "'"
								+ ", '" + people.getLocations().getCountry() + "', " + ress.getRow() + ")";
				
				ConnectionManager.executeUpdate(localInsert);
				
				String interestsInsert = "INSERT INTO interest VALUES (" + ress.getRow() + ", '" + InterestDao.getInterestId(0).get(0).getTitle() + "')";
				
				ConnectionManager.executeUpdate(interestsInsert);
			} else if(people.getId() != null && people.getId() > (size+1)) {
				System.out.println("Person id out of range!");
				throw new SQLException();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Set<Peoples> findInterestGroup(Interests interest, Locations location){
		
		ResultSet results = ConnectionManager.executeQuery("SELECT * FROM person"
				+ " INNER JOIN interest ON person.interest_id = interest.id"
				+ " INNER JOIN locations ON person.id = locations.person_id"
				+ " WHERE title='" + interest.getTitle() + "' AND state='" + location.getState() + "';");
		
		Set<Peoples> people = new HashSet<Peoples>();
		
		try {
			while(results.next()){
				Locations local;
				
				local = new Locations(LocationDao.getLocationId(results.getInt(1)).get(0).getId(), LocationDao.getLocationId(results.getInt(1)).get(0).getCity(), location.getState(), LocationDao.getLocationId(results.getInt(1)).get(0).getCountry(), LocationDao.getLocationId(results.getInt(1)).get(0).getPerson_id());
				
				Set<Interests> interests = new HashSet<Interests>();
				Interests interestss = new Interests(InterestDao.getInterestId(results.getInt(5)).get(0).getId(), interest.getTitle());
				interests.add(interestss);
				
				people.add(new Peoples(results.getInt(1), results.getString(2), results.getString(3), results.getInt(4), results.getInt(5), local, interests));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return people;
	}
	
	public static void main(String[] args) {
		
		Peoples people = new Peoples();
		people.setId(null);
		people.setAge(25);
		people.setFirstName("Jason");
		people.setLastName("Brown");
		people.setInterestid(1);
		Locations location = new Locations();
		location.setId(null);
		location.setCity("Memphis");
		location.setState("Tennesse");
		location.setCountry("United States of America");
		location.setPerson_id(null);
		people.setLocations(location);
		Set<Interests> interest = new HashSet<Interests>();
		Interests interests = new Interests();
		interests.setId(null);
		interests.setTitle("Basketball");
		interest.add(interests);
		people.setInterests(interest);
		
		PeoplesDao.savePeople(people);
	}
}
