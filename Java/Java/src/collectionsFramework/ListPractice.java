package collectionsFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class Student {
	private int id;
	private String nam;
	
	public Student(int id, String nam) {
		this.id = id;
		this.nam = nam;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNam() {
		return nam;
	}

	public void setNam(String nam) {
		this.nam = nam;
	}
	
	public String toString() {
		return nam;
	}
	
}


class StringLengthOrderComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		int l1 = o1.length();
		int l2 = o2.length();
		
		if (l1 > l2) return 1;
		else if (l1 < l2) return -1;
		
		return 0;
	}

	
}


class AlphabeticalOrderComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}

	
}

class ReverseAlphabeticalOrderComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		// or we can write this also -
		//return - o1.compareTo(o2);
		return o2.compareTo(o1);
	}

	
}

public class ListPractice {

	public static void main(String[] args) {
		
		// ###################   LIST SORTING   ###################
		List<String> lt1 = new ArrayList<>();
		addItem(lt1);
		
		// only sort based on alphabetical order
		//Collections.sort(lt1);
		
		
		// sort based on length
		//Collections.sort(lt1, new StringLengthOrderComparator());
		
		// sort based on alphabetical
		//Collections.sort(lt1, new AlphabeticalOrderComparator());
		
		// sort based on reverse alphabetical
		Collections.sort(lt1, new ReverseAlphabeticalOrderComparator());
		
		
		//  ANOTHER WAY TO REVERSE LIST
		/*
		 Collections.sort(lt1, Comparator<Integer> {
e
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		 */
		
		for(String item: lt1) {
			System.out.print(item + " ");
		}
		System.out.println();
		
		
		
		
		

		// ###################   SORTING ARBITARY OBJECTS   ###################
		List<Student> stuObj = new ArrayList<>();
		stuObj.add(new Student(2, "Amit"));
		stuObj.add(new Student(4, "Rahul"));
		stuObj.add(new Student(6, "Darshan"));
		stuObj.add(new Student(1, "Pal"));
		stuObj.add(new Student(5, "Khal"));
		stuObj.add(new Student(3, "Raj"));
		
		
		
		for(Student student: stuObj) {
			System.out.println("ID : "+ student.getId() + " NAME: " + student.getNam());
		}
		System.out.println();
		
		
		// ######### SORT BASED ON ID OF STUDENT #########
		
		Collections.sort(stuObj, new Comparator<Student>() {

			@Override
			public int compare(Student s1, Student s2) {
				
				int id1 = s1.getId();
				int id2 = s2.getId();
				
				if (id1 > id2) return 1;
				if (id1 < id2) return -1;				
				return 0;
			}
			
		});

		System.out.println("\n######### SORT BASED ON ID OF STUDENT #########\n");
		for(Student student: stuObj) {
			System.out.println("ID : "+ student.getId() + " NAME: " + student.getNam());
		}
		System.out.println();
		
		
		// ######### SORT BASED ON NAME(ALPHABETICAL) OF STUDENT #########
		
		Collections.sort(stuObj, new Comparator<Student>() {

			@Override
			public int compare(Student s1, Student s2) {				
				return s1.getNam().compareTo(s2.getNam());
			}
			
		});

		System.out.println("\n######### SORT BASED ON NAME(ALPHABETICAL) OF STUDENT #########\n");
		for(Student student: stuObj) {
			System.out.println("ID : "+ student.getId() + " NAME: " + student.getNam());
		}
		System.out.println();
		
	}
	private static void addItem(List<String> lt1) {
		lt1.add("xlkfirejflj");
		lt1.add("dfjdsdj");
		lt1.add("fj");
		lt1.add("lkfiflj");
		lt1.add("2");
		lt1.add("abc");
	}

}
