package ioJavaExample;

import java.io.FileOutputStream;

public class FileOutputStreamEx {

	public static void main(String[] args) {
		// write byte
		try{    
            FileOutputStream fout=new FileOutputStream("D:\\codes\\eclipse-workspace\\JavaPractice\\src\\ioJavaExample\\text_file.txt");    
            fout.write(65);    
            fout.close();    
            System.out.println("success...");    
           }catch(Exception e){System.out.println(e);}    
		
		System.out.println("------------------------");
		// write string
		try{    
			FileOutputStream fout=new FileOutputStream("D:\\codes\\eclipse-workspace\\JavaPractice\\src\\ioJavaExample\\text_file.txt");    
            String s="This is the message.";    
            byte b[]=s.getBytes();//converting string into byte array    
            fout.write(b);    
            fout.close();    
            System.out.println("success...");    
           }catch(Exception e){System.out.println(e);}    
		
		
		System.out.println("------------------------");
	}

}
