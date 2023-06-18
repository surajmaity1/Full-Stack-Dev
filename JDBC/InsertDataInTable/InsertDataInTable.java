// Java Program to Insert Data In In Table(in mysql server) using JDBC
// INSERT PERFORM USING PREPAREDSTATEMENT
import java.sql.*;

class InsertDataInTable {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/program";
            String root = "root";
            String pwd = "1234";

            Connection con = DriverManager.getConnection(url,root,pwd);

            String insertQuery = "INSERT INTO Table1(name, address) VALUES(?,?)";
            
            PreparedStatement psmnt = con.prepareStatement(insertQuery);

            psmnt.setString(1, "Arnab Shaw");
            psmnt.setString(2, "Haldia");

            psmnt.executeUpdate();

            System.out.println("Data Inserted in Table1 ...");
            con.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}