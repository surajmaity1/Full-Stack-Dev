package dateTimeApi;

import java.time.LocalDateTime;
import java.time.Month;

// Working With LocalDateTime
public class LocalDateTimeEx {

	public static void main(String[] args) {
		LocalDateTime a1 = LocalDateTime.now();
		LocalDateTime a2 = LocalDateTime.of(2023, Month.JUNE, 04, 20, 00);
		LocalDateTime a3 = LocalDateTime.parse("2023-06-21T04:20:00");
		LocalDateTime a4 = a1.plusDays(3);
		LocalDateTime a5 = a2.minusHours(4);
		Month a6 = a3.getMonth();
		System.out.println(a1 +" \t" +a2 +" \t" +a3 +" \t" );
		System.out.println(a4 +" \t" +a5 +" \t" +a6 +" \t" );
	}

}
