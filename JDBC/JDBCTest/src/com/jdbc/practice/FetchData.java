package com.jdbc.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FetchData {

	public static void main(String[] args) {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/program";
            String root = "root";
            String pass = "1234";

            Connection con = DriverManager.getConnection(url, root, pass);
            
            String query="SELECT * FROM Table1";
            
            Statement stmnt = con.createStatement();

            ResultSet res = stmnt.executeQuery(query);

            while(res.next()) {
            	int id = res.getInt("id");
            	String name = res.getString("name");
            	String address = res.getString("address");
            	System.out.println("id:\t"+id+"\tname:\t"+name+"\taddress:\t"+address);
            }

            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
	}

}
