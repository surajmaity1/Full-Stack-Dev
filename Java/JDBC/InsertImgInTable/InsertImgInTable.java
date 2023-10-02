// Java Program to Insert Image In In Table(in mysql server) using JDBC
// INSERT PERFORM USING PREPAREDSTATEMENT
import java.sql.*;
import java.io.*;

class InsertImgInTable {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/program";
            String root = "root";
            String pwd = "1234";

            Connection con = DriverManager.getConnection(url,root,pwd);

            String insertQuery = "INSERT INTO ImgTable(img) VALUES(?)";
            
            PreparedStatement psmnt = con.prepareStatement(insertQuery);
            
            FileInputStream fis = new FileInputStream("img1.jpg");

            psmnt.setBinaryStream(1, fis, fis.available());

            psmnt.executeUpdate();

            System.out.println("Data Inserted in Table1 ...");
            con.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}