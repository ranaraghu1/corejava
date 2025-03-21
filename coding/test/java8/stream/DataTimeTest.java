package test.java8.stream;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DataTimeTest {
	public static void main(String args[]) {
		LocalDate date=LocalDate.now();
		System.out.println("current date::"+date);
		
		//Date after 3 months
		LocalDate date1=LocalDate.now().plusMonths(3);
		System.out.println("date after 3 months::"+date1);
		
		//Date after 3 days
		LocalDate date2=LocalDate.now().plusDays(3);
		System.out.println("date after 3 days::"+date2);
		
		//Date before 5 days
		LocalDate beforeDate=LocalDate.now().minusDays(5);
		System.out.println("date before 5 days::"+beforeDate);
		
		//which date come first.
		if(date1.isAfter(date2)) {
			System.out.println("date1 is newer date");
		}else {
			System.out.println("date2 is newer date");
		}
		
		//calculate date after 2 years 3 months 4 weeks and 2 days
		LocalDate date3=LocalDate.now().plus(Period.ofYears(2)).plus(Period.ofMonths(3)).plus(Period.ofWeeks(4)).plus(Period.ofDays(2));
		System.out.println("date after 2 years 3 months 4 weeks and 2 days:::"+date3);
		
		ZoneId kolkata=ZoneId.of("Asia/Calcutta");
		ZonedDateTime date4 =ZonedDateTime.now(kolkata);
		System.out.println("Zoned date:::"+date4);
		
		System.out.println(date4.getYear()+" "+date4.getMonth()+" "+date4.getDayOfMonth());
		
		
	}

}
