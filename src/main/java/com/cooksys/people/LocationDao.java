package com.cooksys.people;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocationDao {
	
	public static List<Locations> getLocationId(Integer id) {
		
		ResultSet results = ConnectionManager.executeQuery("SELECT * FROM locations WHERE location_id='" + id + "'");
		
		ArrayList<Locations> local = new ArrayList<Locations>();
		
		try {
			while(results.next()){
				local.add(new Locations(results.getInt(1), results.getString(2), results.getString(3), results.getString(4), results.getInt(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return local;
	}
	
	public static String saveLocation(Locations local) {

		int size = 0;
		ResultSet ress = ConnectionManager.executeQuery("SELECT * FROM locations");
		
		try {
			if(ress != null) {
				ress.last();
				size = ress.getRow();
			}
			
			if (local.getId() != null && local.getId() <= (size+1)){
				String sqlUpdate = "UPDATE locations SET city='" + local.getCity() + "', state='" + local.getState() + 
						"', country='" + local.getCountry() + "', " + local.getPerson_id() + " WHERE id=" + local.getId() +";";
				
				ConnectionManager.executeUpdate(sqlUpdate);
				
				return "Success!";
			} else if (local.getId() == null) {
				String sqlInsert = "INSERT INTO locations VALUES (" + ress.getRow() +", "
						+ "'" + local.getCity() + "', '" + local.getState() + "', "
								+ "'" + local.getCountry() + "', " + local.getPerson_id() + ")";
			
				ConnectionManager.executeUpdate(sqlInsert);
				
				return "Success!";
			} else if(local.getId() != null && local.getId() > (size+1)) {
				System.out.println("Locations id out of range!");
				throw new SQLException();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Success!";
	}
	
	public static void main(String[] args) {
		Locations locals = new Locations();
		locals.setId(null);
		locals.setCity("Kairo");
		locals.setState("N/A");
		locals.setCountry("Egypt");
		locals.setPerson_id(3);
	
		LocationDao.saveLocation(locals);
	}
}
