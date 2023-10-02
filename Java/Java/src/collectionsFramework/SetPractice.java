package collectionsFramework;

import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeSet;


public class SetPractice {

	public static void main(String[] args) {
		Set<Integer> hashSet = new HashSet<Integer>();
		Set<Integer> linkedHashSet = new LinkedHashSet<Integer>();
		Set<Integer> treeSet = new TreeSet<Integer>();
		
		addValue(hashSet);
		//addValue(linkedHashSet);
		//addValue(treeSet);
		
		
		
		/*
		// check one item is present or not
		if (treeSet.contains(32)) {
			System.out.println("\n32 contains");
		}
		else {
			System.out.println("\n32 doesn't contains");
		}
		
		
		
		// check empty or not
		
		if (treeSet.isEmpty()) {
			System.out.println("\nSet is Empty");
		}
		else {
			System.out.println("\nSet is not Empty");
		}
		*/

		
		Set<Integer> set2 = new TreeSet<Integer>();
		set2.add(43);
		set2.add(3);
		set2.add(5);
		
		// ######### INTERSECTION #########
		
		Set<Integer> intersection = new HashSet<Integer>(hashSet);
		/*
		 * The retainAll() method of java.util.Set interface is used to 
		 * retain from this set all of its elements 
		 * that are contained in the specified collection.
		 */
		intersection.retainAll(set2);
		
		System.out.println(intersection);
		
		

		// ######### DIFFERENCE #########
		
		
		Set<Integer> diff = new HashSet<Integer>(hashSet);
		
		/*
		 * The removeAll() method of java.util.Set interface is used to 
		 * remove from this set all of its elements 
		 * that are contained in the specified collection.
		 */
		diff.removeAll(set2);
		
		System.out.println(diff);
		
		
	}
	private static void addValue(Set<Integer> set) {
		set.add(4);
		set.add(5);
		set.add(3);
		set.add(6);
		set.add(2);
		set.add(1);
		
		// Add existing value
		// Note: Set doesn't contain duplicate value
		set.add(4);
		
		fetchSet(set);
	}

	private static void fetchSet(Set<Integer> set) {
		// Using println
		//System.out.println(set);
		
		// Using loop
		for(Integer item: set) {
			System.out.print(item + " ");
		}
		System.out.println();
	}

}
