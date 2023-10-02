package dateTimeApi;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

// Working With LocalTime
public class LocalTimeEx {

	public static void main(String[] args) {
		
		// instance of current LocalTime 
		LocalTime now = LocalTime.now();
		System.out.println(now);
		
		//create a LocalTime representing 04:20 a.m. by parsing a string
		LocalTime a1 = LocalTime.parse("04:20");
		System.out.println(a1);
		
		// creates LocalTime representing 04:20 a.m. using the factory method
		LocalTime a2 = LocalTime.of(4, 20);
		System.out.println(a2);
		
		
		// adding an hour to it by using the “plus” API
		LocalTime a3 = LocalTime.parse("04:20").plus(2, ChronoUnit.HOURS);
		System.out.println(a3);
		
		// get specific units of time like hour, min and secs
		int a4 = LocalTime.parse("04:20").getHour();
		System.out.println(a4);
		
		//  check if a specific time is before or after another specific time. 
		boolean isbefore = LocalTime.parse("08:10").isBefore(LocalTime.parse("04:20"));
		System.out.println(isbefore);

		// the max, min and noon time of a day can be obtained by constants in LocalTime class. This is very useful when performing database queries to find records within a given span of time.
		LocalTime minTime = LocalTime.MIN;
		System.out.println(minTime);
	}

}
