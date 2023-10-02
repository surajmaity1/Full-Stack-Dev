package ioJavaExample;

import java.io.IOException;

public class IOJavaEx1 {

	public static void main(String[] args) throws IOException {
		System.out.println("Simple Message");
		System.err.println("Error Message");
		
		// get input from console
		// it will store as a ascii value 
		
		int val = System.in.read(); //returns ASCII code of 1st character 
		
		// convert ASCII val to char
		System.out.println((char)val);
		
	}

}
