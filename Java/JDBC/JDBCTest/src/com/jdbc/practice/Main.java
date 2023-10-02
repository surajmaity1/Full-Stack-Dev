// Java Program to Insert Large Image In In Table(in mysql server) using JDBC
// INSERT PERFORM USING PREPAREDSTATEMENT

package com.jdbc.practice;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		try {
			Connection connection = ConnectionProvider.getConnection();
			
			String largeImgAddQuery = "INSERT INTO ImgTable(img)values(?)";
			
			PreparedStatement psmnt = connection.prepareStatement(largeImgAddQuery);
			
			JFileChooser jFileChooser = new JFileChooser();
			jFileChooser.showOpenDialog(null);
			
			File file= jFileChooser.getSelectedFile();
			
			FileInputStream fileInputStream = new FileInputStream(file);
			
			psmnt.setBinaryStream(1, fileInputStream, fileInputStream.available());
			
			psmnt.executeUpdate();
			
			// show gui message 
			JOptionPane.showMessageDialog(null, "Done ...");
			
			connection.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
