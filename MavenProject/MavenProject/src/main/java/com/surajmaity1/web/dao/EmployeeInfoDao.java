package com.surajmaity1.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.surajmaity1.web.model.EmplyeeInfo;

public class EmployeeInfoDao {

	String url = "jdbc:mysql://localhost:3306/employee_info";
	String query = "select * from employee where id=";
    String root = "root";
    String pass = "1234";
    
	public EmplyeeInfo getEmployeeInfo(int id) {
		EmplyeeInfo emplyeeInfo = new EmplyeeInfo();
		/*
		emplyeeInfo.setId(1);
		emplyeeInfo.setName("Suraj");
		emplyeeInfo.setProject("SOFT DEV");
		*/
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");


            Connection con = DriverManager.getConnection(url, root, pass);
            
            
            Statement stmnt = con.createStatement();
            ResultSet res = stmnt.executeQuery(query + id);

            if (res.next()) {
            	emplyeeInfo.setId(res.getInt("id"));
        		emplyeeInfo.setName(res.getString("name"));
        		emplyeeInfo.setProject(res.getString("project"));
            }
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return emplyeeInfo;
	}
}
