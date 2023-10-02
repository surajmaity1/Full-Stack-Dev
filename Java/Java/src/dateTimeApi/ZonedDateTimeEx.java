package dateTimeApi;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Set;

// Using ZonedDateTime API
public class ZonedDateTimeEx {

	public static void main(String[] args) {
		ZoneId zoneId = ZoneId.of("Asia/Kolkata");

		Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
		
		System.out.println(allZoneIds);
		ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), zoneId);
		
		ZonedDateTime.parse("2023-06-21T10:15:30+01:00[Europe/Paris]");
		
		LocalDateTime localDateTime = LocalDateTime.of(2023, Month.JUNE, 21, 06, 30);
		
		ZoneOffset offset = ZoneOffset.of("+02:00");

		OffsetDateTime offSetByTwo = OffsetDateTime
		  .of(localDateTime, offset);
		
		

		System.out.println(zoneId +" \t" +"\t" +zonedDateTime +" \t" );
		System.out.println(localDateTime +" \t" +offset);
		System.out.println(offSetByTwo);
		
	}

}
