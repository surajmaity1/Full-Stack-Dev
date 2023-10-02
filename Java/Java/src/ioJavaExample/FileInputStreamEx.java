package ioJavaExample;

import java.io.FileInputStream;

public class FileInputStreamEx {

	public static void main(String[] args) {
		// read single character
		try{    
            FileInputStream fin=new FileInputStream("D:\\codes\\eclipse-workspace\\JavaPractice\\src\\ioJavaExample\\text_file.txt");    
            int i=fin.read();  
            System.out.print((char)i);    
  
            fin.close();    
          }catch(Exception e){System.out.println(e);}  
		
		System.out.println("\n------------------------");
		// read all characters
		try{    
			FileInputStream fin=new FileInputStream("D:\\codes\\eclipse-workspace\\JavaPractice\\src\\ioJavaExample\\text_file.txt");    
            int i=0;    
            while((i=fin.read())!=-1){    
             System.out.print((char)i);    
            }    
            fin.close();    
          }catch(Exception e){System.out.println(e);}   
		
	}

}
