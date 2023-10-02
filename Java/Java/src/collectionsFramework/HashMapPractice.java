package collectionsFramework;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapPractice {

	public static void main(String[] args) {
		// Hashmap doesn't maintain insertion order 
		//When elements get from the HashMap due to hashing the order they inserted is not maintained while retrieval. 
		HashMap<Character, String> hashMap = new HashMap<>();
		
		// The LinkedHashMap class implements a doubly-linked list so that it can traverse through all the elements.
		// LinkedHashMap maintain insertion order 
		Map<Character, String> linkedHashMap = new LinkedHashMap<>();
		
		// TreeMap sort the keys by order ...
		TreeMap<Character, String> treeMap = new TreeMap<>();


		addValue(hashMap);
		addValue(linkedHashMap);
		addValue(treeMap);
				

		// Note: If I put same key with new value ...
		// recent one will override old one 
		
		hashMap.put('E', "Eclipse");
		
		// If we try to access 'E' key's value, you'll get 'Eclipse'
		String val = hashMap.get('E');
		System.out.println("val: "+ val);
		
		
		
	}
	private static void addValue(Map<Character, String> map) {
		map.put('C', "C Programming");
		map.put('E', "Express");
		map.put('A', "Apple");
		map.put('D', "Database");
		map.put('B', "BigData");

		fetchData1(map);
	}
	
	private static void fetchData1(Map<Character, String> map) {
		
		// retrieve data
		for(Map.Entry<Character, String> item: map.entrySet()) {
			System.out.println(item.getKey() + " : " + item.getValue());
		}
	}
	
	private static void fetchData2(Map<Character, String> map) {

		// another way to retrieve data
		for(Character key: map.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}
	}
	


}
