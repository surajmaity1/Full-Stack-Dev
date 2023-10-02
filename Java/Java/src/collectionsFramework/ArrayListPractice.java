package collectionsFramework;

import java.util.ArrayList;

public class ArrayListPractice {

	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(12);
		arrayList.add(13);
		arrayList.add(14);
		arrayList.add(16);
		arrayList.add(123);

		System.out.println("Arraylist: ");
		System.out.println(arrayList);

		System.out.println("Arraylist: ");
		for(Integer val : arrayList) {
			System.out.println(val);
		}
		
		arrayList.remove(arrayList.size() - 1);
		System.out.println("Arraylist: ");
		
		for(int i = 0; i < arrayList.size(); i++) {
			System.out.print(arrayList.get(i)+ " ");
		}
		
		arrayList.remove(0);
		
		System.out.println("\nArraylist: ");
		for(Integer val : arrayList) {
			System.out.println(val);
		}
	}

}
