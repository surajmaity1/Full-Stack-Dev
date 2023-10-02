// Java Program to Update Data In In Table(in mysql server) using JDBC
// INSERT PERFORM USING PREPAREDSTATEMENT

package com.jdbc.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateData {

	public static void main(String[] args) {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/program";
            String root = "root";
            String pwd = "1234";

            Connection con = DriverManager.getConnection(url,root,pwd);

            String insertQuery = "UPDATE Table1 SET name=?, address=? WHERE id=?";
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            
            System.out.print("Enter ID :: ");
            int idInput = Integer.parseInt(br.readLine());
            
            System.out.print("Enter Name :: ");
            String nameInput = br.readLine();
            
            System.out.print("Enter Address :: ");
            String addressInput = br.readLine();
            
            

            PreparedStatement psmnt = con.prepareStatement(insertQuery);
            psmnt.setString(1, nameInput);
            psmnt.setString(2, addressInput);
            psmnt.setInt(3, idInput);

            psmnt.executeUpdate();

            System.out.println("Data Inserted in Table1 ...");
            con.close();
            br.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
	}

}
