package com.harsh128.helper;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.Driver;

public class ConnectionProvider {
 
	private static Connection connection;
	public static Connection getConnection()
	{
		try {
			
			
			if(connection==null)
			{
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demomytry?characterEncoding=latin1","root","Harsh*11199");	
			}
			
			
			
			
			
		} catch (Exception e) {
			
		}
		return connection;
	}
}
