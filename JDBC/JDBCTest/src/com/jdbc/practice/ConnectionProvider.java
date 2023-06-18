package com.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	private static Connection connection;
	public static Connection getConnection() {
		try {
			
			if (connection == null) {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	
	            String url = "jdbc:mysql://localhost:3306/program";
	            String root = "root";
	            String pass = "1234";
	
	            connection = DriverManager.getConnection(url, root, pass);
	            
			}
        }
        catch(Exception e){
            e.printStackTrace();
        }
		
		return connection;
	}
}
