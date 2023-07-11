package com.surajmaity1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LogInDao {
	String url = "jdbc:mysql://localhost:3306/student_1";
	String query = "select * from login_data where usr_nam=? and pwd=?;";
    String root = "root";
    String pass = "1234";
    
    public boolean checkCredentials(String usr_nam, String pwd) {
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver");


            Connection con = DriverManager.getConnection(url, root, pass);
            
            
            PreparedStatement stmnt = con.prepareStatement(query);
            stmnt.setString(1, usr_nam);
            stmnt.setString(2, pwd);
            ResultSet res = stmnt.executeQuery();

            if (res.next()) {
            	return true;
            }

            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    	
    	
    	return false;
    }
}
