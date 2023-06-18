// Java Program to Insert User Input Data In In Table(in mysql server) using JDBC
// INSERT PERFORM USING PREPAREDSTATEMENT
import java.sql.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class InsertDynamicDataInTable {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/program";
            String root = "root";
            String pwd = "1234";

            Connection con = DriverManager.getConnection(url,root,pwd);

            String insertQuery = "INSERT INTO Table1(name, address) VALUES(?,?)";
            
            PreparedStatement psmnt = con.prepareStatement(insertQuery);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter Name :: ");
            String nameInput = br.readLine();
            System.out.print("Enter Address :: ");
            String addressInput = br.readLine();

            psmnt.setString(1, nameInput);
            psmnt.setString(2, addressInput);

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