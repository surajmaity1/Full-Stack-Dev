// Simple Java Program to establish connection with mysql using JDBC

import java.sql.*;

class Program {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/program";
            String root = "root";
            String pass = "1234";

            Connection con = DriverManager.getConnection(url, root, pass);
            
            if(con.isClosed()) {
                System.out.println("Connection Closed ...");
            }
            else {
                System.out.println("Connection Created ...");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}