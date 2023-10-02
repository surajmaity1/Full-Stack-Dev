package collectionsFramework;

import java.util.Iterator;
import java.util.LinkedList;

public class IteratorPractice {

	//https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
	
	public static void main(String[] args) {
		LinkedList<String> students = new LinkedList<String>();
		 
		students.add("Arit");
		students.add("Augustine");
		students.add("Dojo");
		students.add("Avie");
         
        // "Old" way of iterating through lists (except that generics
        // didn't exist pre Java 5). This way is still an integral part
        // of Java; it allows you to remove items from the list
        // and also supports the "for each" syntax behind the scenes.
 
        Iterator<String> studentsIterator = students.iterator();
 
        System.out.println("Iterate through Iterator:\n");
        
        while (studentsIterator.hasNext()) {
            String value = studentsIterator.next();
            System.out.println(value);
             
            if(value.equals("Dojo")) {
            	studentsIterator.remove();
            }
        }
 
        System.out.println("\nAfter removing using iterator:\n");
         
        /*
         * If you want to add items to a list while iterating through
         * it, get a ListIterator using the .listIterator() method.
         * ListIterator also has a previous() method, allowing you to
         * "rewind" the iterator so that you can add items before
         * the current item.
         */
 
        // / Modern iteration, Java 5 and later; "for each" loop
 
        for (String student : students) {
            System.out.println(student);
             
            // The following won't work; you need an iterator.
            // Throws ConcurrentModificationException
            // student.remove(2);
        }
	}

}
