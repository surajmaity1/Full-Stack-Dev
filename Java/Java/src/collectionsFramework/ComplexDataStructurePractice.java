package collectionsFramework;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class ComplexDataStructurePractice {

	public static String[] subjects = {
			"CS", "ECE", "ME"
	};
	
	public static String[][] students = {
			{ "Arit", "Augustine", "Dojo"},
			{ "Bikram", "Ranjit", "Suman", "Labav", "Avie"},
			{ "Manish", "Mary", "Crina", "Tina", "Diya"},
	};
	
	
	public static void main(String[] args) {
		Map<String, Set<String>> data = new HashMap<>();
		
		for(int i=0; i < subjects.length; i++) {
			String sub = subjects[i];
			String[] studentList = students[i];
			
			Set<String> studentsList = new LinkedHashSet<>();
			
			for (String student: studentList) {
				studentsList.add(student);
			}
			
			data.put(sub, studentsList);
			
		}

		for(String eachSubject: data.keySet()) {
			Set<String> studentList = data.get(eachSubject);
			
			System.out.println("Subject: "+eachSubject+" | Assigned Students:"+studentList);
		}
	}

}
