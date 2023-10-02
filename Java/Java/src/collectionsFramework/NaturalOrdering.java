package collectionsFramework;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

class Human implements Comparable<Human> {
    private String name;
     
    public Human(String name) {
        this.name = name;
    }
     
    public String toString() {
        return name;
    }
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Human other = (Human) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
    /*
    public int compareTo(Human h) {
    	
    	// sort alphabetically
    	return name.compareTo(h.name);
    	
    	
    	// sort alphabetically in reverse
    	//return -name.compareTo(h.name);
    }
 	*/
    
    @Override
    public int compareTo(Human h) {
        int len1 = name.length();
        int len2 = h.name.length();
         
        if(len1 > len2) {
            return 1;
        }
        else if(len1 < len2) {
            return -1;
        }
        else {
            return name.compareTo(h.name);
        }
    }
}
 
public class NaturalOrdering {

	public static void main(String[] args) {
		List<Human> list = new ArrayList<>();
        SortedSet<Human> set = new TreeSet<>();
         
        addData(list);
        addData(set);
         
        Collections.sort(list);
         
        fetchItems(list);
        System.out.println();
        fetchItems(set);
    }
     
    private static void addData(Collection<Human> list) {
    	list.add(new Human("Amit"));
    	list.add(new Human("Rahul"));
    	list.add(new Human("Pal"));
    	list.add(new Human("Raj"));
    	list.add(new Human("Darshan"));
    }
     
    private static void fetchItems(Collection<Human> list) {
        for(Human item: list) {
            System.out.println(item);
        }
    }
}