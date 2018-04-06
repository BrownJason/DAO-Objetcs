package com.cooksys.people;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
	
	{
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ResultSet executeQuery(String query) {
		
		Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/people", "postgres", "bondstone");
			
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
			
			ResultSet result = statement.executeQuery(query);
			
			connection.close();
			
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static Integer executeUpdate(String query) {
		Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/people", "postgres", "bondstone");
			
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
			
			Integer save = statement.executeUpdate(query);
			
			connection.close();
			
			return save;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
