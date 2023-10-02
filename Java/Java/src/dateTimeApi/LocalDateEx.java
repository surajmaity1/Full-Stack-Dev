package dateTimeApi;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;


// Working With LocalDate

public class LocalDateEx {
    public static void main(String[] args) {

        // instance of current date can be created from the system clock
        LocalDate ld1 = LocalDate.now();
        System.out.println(ld1);

        Clock clock = Clock.systemDefaultZone();
        LocalDate ld2 = LocalDate.now(clock);
        System.out.println(ld2);

        ZoneId zoneId = ZoneId.of("Asia/Dhaka");
        LocalDate localDate3 = LocalDate.now(zoneId);

        System.out.println(localDate3);

        System.out.println("\n\n------------------\n");

        // code snippets represent the LocalDate for February 20, 2015
        LocalDate a1 = LocalDate.of(2015, 03, 12);
        LocalDate a2 = LocalDate.parse("2023-03-12");
        System.out.println(a1);
        System.out.println(a2);
        

        System.out.println("\n\n------------------\n");

        // the current local date and adds one day
        LocalDate tomorrow = LocalDate.now().plusDays(6);
        System.out.println(tomorrow);

        // current date and subtracts three month
        LocalDate threeMonthBackSameDay = LocalDate.now().minus(3, ChronoUnit.MONTHS);
        System.out.println(threeMonthBackSameDay);



        System.out.println("\n\n------------------\n");
        // parse the date "2023-06-21" and get the day of the week and the day of the month respectively
        DayOfWeek day = LocalDate.parse("2023-06-21").getDayOfWeek();
        int date = LocalDate.parse("2023-06-21").getDayOfMonth();
        System.out.println(day + " " + date);

        //  test if a date occurs in a leap year
        boolean leapYear = LocalDate.now().isLeapYear();
        System.out.println(leapYear);



        System.out.println("\n\n------------------\n");
        // relationship of a date to another can be determined to occur before or after another date
        boolean notBefore = LocalDate.parse("2023-06-21")
        		  .isBefore(LocalDate.parse("2024-06-21"));

        boolean isAfter = LocalDate.parse("2023-06-21")
        		  .isAfter(LocalDate.parse("2023-06-21"));
        System.out.println(notBefore + " " + isAfter);
        
        
        
        System.out.println("\n\n------------------\n");
        // get the LocalDateTime that represents the beginning of the day
        LocalDateTime beginningOfDay = LocalDate.parse("2023-06-21").atStartOfDay();
        
        // firstDayOfMonth that represents the beginning of the month 
        LocalDate firstDayOfMonth = LocalDate.parse("2023-06-21")
          .with(TemporalAdjusters.firstDayOfMonth());
        
        System.out.println(beginningOfDay + " " + firstDayOfMonth);
        
        
        
        
        System.out.println("\n\n------------------\n");
        
        
        
    }
}
