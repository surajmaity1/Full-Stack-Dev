package dateTimeApi;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

// Compatibility With Date and Calendar
// Date and Time Formatting
public class DTCDTFEx {

	public static void main(String[] args) {
		// Compatibility With Date and Calendar
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		
		// toInstant() method, which helps to convert 
		//existing Date and Calendar instance to new Date and Time API:
		LocalDateTime ld1 = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
		LocalDateTime lt1 = LocalDateTime.ofInstant(calendar.toInstant(), ZoneId.systemDefault());
		
		System.out.println(ld1.toLocalDate());
		System.out.println(ld1.toLocalTime());
		System.out.println(lt1.toLocalDate());
		System.out.println(lt1.toLocalTime());

		
		
		
		// Date and Time Formatting
		// Java 8 provides APIs for the easy formatting of Date and Time
		
		LocalDateTime localDateTime = LocalDateTime.of(2023, Month.JUNE, 21, 3, 40);
		
		String localDateString = localDateTime.format(DateTimeFormatter.ISO_DATE);
		
		
		String a6 = localDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		
		String a7 = localDateTime
				  .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
						  .withLocale(Locale.UK));
		

		System.out.println(localDateString);
		System.out.println(a6);
		System.out.println(a7);
	}

}
