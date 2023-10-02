package dateTimeApi;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

// Working With Period
//Working With Duration
public class PeriodAndDurationEx {

	public static void main(String[] args) {
		/*
		Period class represents a quantity of time in terms of years, months and days,
		 and the Duration class represents a quantity of time in terms of seconds and nanoseconds.
		 */
		LocalDate initialDate = LocalDate.parse("2023-06-21");
		
		LocalDate finalDate = initialDate.plus(Period.ofDays(9));
		
		int a1 = Period.between(initialDate, finalDate).getDays();
		
		long a2 = ChronoUnit.DAYS.between(initialDate, finalDate);
		
		System.out.println(initialDate);
		System.out.println(finalDate);
		System.out.println(a1);
		System.out.println(a2);
		
		
		System.out.println("\n---------------------\n");
		
		LocalTime initialTime = LocalTime.of(4, 45, 12);

		LocalTime finalTime = initialTime.plus(Duration.ofSeconds(23));
		
		
		long a3 = Duration.between(initialTime, finalTime).getSeconds();
		
		long a4 = ChronoUnit.SECONDS.between(initialTime, finalTime);
		
		System.out.println(initialTime);
		System.out.println(finalTime);
		System.out.println(a3);
		System.out.println(a4);
	}

}
