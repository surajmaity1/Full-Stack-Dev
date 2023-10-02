package streamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApiEx {

	public static void main(String[] args) {
		List<Integer> l1 = List.of(32,5,3421, 984, 939, 3213);
		System.out.println(l1);
		
		
		// find even and put in new arrayList
		// Without stream
		List<Integer> l2 = new ArrayList<>();
		for(int a: l1) {
			if(a%2==0) l2.add(a);
		}
		System.out.println(l2);
		
		
		
		
		// With stream
		Stream<Integer> s1 = l1.stream();
		List<Integer> l3 = s1.filter(val-> val%2 == 0).toList();
		//List<Integer> l4 = s1.filter(val-> val%2 == 0).collect(Collectors.toList());
		System.out.println(l3);
				

		List<Integer> l5 = List.of(32,5,3421, 984, 939, 3213);
		
		// doing in one line
		List<Integer> l6 = l5.stream().filter(val -> val %2 == 0).toList();
		System.out.println(l6);
		
		
		
		System.out.println("\n-----------------\n");
		
		// Make an blank Stream object
		Stream<Object> stream = Stream.empty();
		
		// print stream data
		stream.forEach(data -> {
			System.out.println(data);
		});
		
		List<String> strLst = List.of("Abc", "Defg", "Ij", "Dog");
		Stream<String> stream2 = strLst.stream();
		stream2.forEach(System.out::println);

		System.out.println("\n-----------------\n");
		String[] demo = {"Abc", "Defg", "Ij", "Dog"};
		Stream<String> stream3 = Stream.of(demo);
		stream3.forEach(System.out::println);
		
		// Stream Builder
		Stream<Object> streamBld = Stream.builder().build();
		

		System.out.println("\n-----------------\n");
		// Int Stream
		IntStream intArrStream = Arrays.stream(new int[] {1,2,3,4,5,6});
		intArrStream.forEach(System.out::println);
		

		System.out.println("\n-----------------\n");
		List<String> stream4 = strLst.stream().filter(data -> data.startsWith("D")).toList();
		stream4.stream().forEach( data -> {
			System.out.println(data);
		});

		System.out.println("\n-----------------\n");
		List<Integer> lst2 = List.of(1,2,3,4,5,6);
		List<Integer> stream5 = lst2.stream().map(data -> data*data).toList();
		System.out.println(stream5);
		System.out.println("\n-----------------\n");
		
		// sort
		lst2.stream().sorted().forEach(System.out::println);
		
		// Calculate Min
		Integer min = lst2.stream().min((x,y) -> x.compareTo(y)).get();
		
		
		// Calculate Max
		Integer max = lst2.stream().max((a,b) -> a.compareTo(b)).get();
		
	}

}
