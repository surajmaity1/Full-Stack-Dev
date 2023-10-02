// Java Program to create table in mysql using JDBC

import java.sql.*;

class CreateTableProgram {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Note: First create one database manually in server, (example: name database) [Query: create database program;]
            String url = "jdbc:mysql://localhost:3306/program";
            String root = "root";
            String pwd = "1234";

            Connection con = DriverManager.getConnection(url,root,pwd);
            String query="CREATE TABLE Table1(id INTEGER PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100) NOT NULL, address VARCHAR(500))";
            
            Statement stmnt = con.createStatement();

            stmnt.executeUpdate(query);

            System.out.println("Table1 created ...");

            con.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }
}