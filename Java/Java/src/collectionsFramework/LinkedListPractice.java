package collectionsFramework;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListPractice {

	public static void main(String[] args) {
		
		// ArrayList internally uses a dynamic array to store the elements.
		// LinkedList internally uses a doubly linked list to store the elements.
		
		
		LinkedList<Integer> ll = new LinkedList<Integer>();
		
		ll.add(23);
		ll.add(43);
		ll.add(923);
		ll.add(4763);
		ll.add(92343);
		ll.add(44353);
		ll.add(9237);
		ll.add(98487);
		
		System.out.println(ll);
		
		ll.remove();
		ll.removeFirst();
		ll.remove(2);

		System.out.println(ll);
		
		
		// Compare between arrayList and linkedList
		
		/*
		 * Note:
		 *  ArrayList work efficiently when items are added at the last position
		 *  LinkedList  work efficiently when items are added at any position 
		 */
		List<Integer> arrayList = new ArrayList<Integer>();
		List<Integer> linkedList = new LinkedList<Integer>();
		
		measureTime("ArrayList", arrayList);
		measureTime("LinkedList", linkedList);
	}
	
	private static void measureTime(String type, List<Integer> lst) {
		for(int i=0; i<1E5; i++) {
			lst.add(i);
		}
		long st = System.currentTimeMillis();
		
		
		
		// if items are added at the first position, array list performs slow.
		// But LinkedList don't care wherever you add items.
		
		/*for(int i=0; i<1E5; i++) {
			lst.add(0, i);
		}
		*/

		for(int i=0; i<1E5; i++) {
			lst.add(0, i);
		}
		
		long et = System.currentTimeMillis();
		
		System.out.println("Time taken: " + (et-st) + " ms for "+ type);
		
	}

}
