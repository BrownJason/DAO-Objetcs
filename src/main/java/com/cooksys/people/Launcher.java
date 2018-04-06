package com.cooksys.people;

import java.sql.SQLException;

public class Launcher {

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Interests interest = new Interests("Golf");
		Locations location = new Locations("Michigan");
		
		for(Peoples p : PeoplesDao.findInterestGroup(interest, location)){
			System.out.println(p);
		}
	}
}
