package com.jsp.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HelperClass {

	public Connection getConnection()
	{
		String url="jdbc:mysql://localhost:3306/javabatch";
		String user="root";
		String password="root";
		Connection connection=null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection=DriverManager.getConnection(url, user, password);
			
	    	} catch (ClassNotFoundException e) 
		 {
			e.printStackTrace();
		 } catch (SQLException e) 
		 {
			e.printStackTrace();
	     }
		
		return connection;
	}
}
