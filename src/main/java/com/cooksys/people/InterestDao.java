package com.cooksys.people;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InterestDao {

	public static List<Interests> getInterestId(Integer id) {
		
		ResultSet results = ConnectionManager.executeQuery("SELECT * FROM interest WHERE id='" + id +"'");
		
		ArrayList<Interests> interests = new ArrayList<Interests>();
		
		try {
			while(results.next()){
				interests.add(new Interests(results.getInt(1), results.getString(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return interests;
	}
	
	public static String saveInterest(Interests interest) {

		int size = 0;
		ResultSet ress = ConnectionManager.executeQuery("SELECT * FROM interest");
		
		try {
			if(ress != null) {
				ress.last();
				size = ress.getRow();
			}
			
			if (interest.getId() != null && interest.getId() <= (size+1)){
				String sqlUpdate = "UPDATE interest SET id='" + interest.getId() + "', title='" + interest.getTitle() + "' WHERE id=" + interest.getId() +";";
				
				ConnectionManager.executeUpdate(sqlUpdate);
				
				return "Success!";
			} else if (interest.getId() == null) {
				String sqlInsert = "INSERT INTO interest VALUES (" + ress.getRow() +", '" + interest.getTitle() + "')";
			
				ConnectionManager.executeUpdate(sqlInsert);
				
				return "Success!";
			} else if(interest.getId() != null && interest.getId() > (size+1)) {
				System.out.println("interest id out of range!");
				throw new SQLException();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Success!";
	}
	
	public static void main(String[] args) {
		Interests int1 = new Interests();
		int1.setId(null);
		int1.setTitle("Pro Gamer");
		
		InterestDao.saveInterest(int1);
	}
}
