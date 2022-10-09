package ch10_StringManipulation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;

public class FormattingDate {

	public static void main(String[] args) {

		String d = String.format("%tc", new Date()); // %tc: date and time
		System.out.println(d);

		String t = String.format("%tr", new Date()); // %tr: just the time
		System.out.println(t);

		// another way of getting the current time and turning it into a String in the format of HH:MM:SS
		String currentTime = LocalDateTime.now()
						.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));
		System.out.println(currentTime);

		Date today = new Date();
		// %tA: day of week; %tB: month; %td: day of month
		String s1 = String.format("%tA, %tB %td", today, today, today);
		System.out.println(s1);

		// the angle-bracket “<” tells the formatter to “use the previous argument again”
		String s2 = String.format("%tA, %<tB %<td", today);
		System.out.println(s2);

		Calendar gc = Calendar.getInstance();// return GregorianCalendar object (Calendar's concrete subclass)
		System.out.println("\n" + gc.getTime());
		System.out.println("year: " + gc.get(Calendar.YEAR));
		System.out.println("month: " + gc.get(Calendar.MONTH)); // month is zero-based
		System.out.println("day of month: " + gc.get(Calendar.DAY_OF_MONTH));
		System.out.println("day of week: " + gc.get(Calendar.DAY_OF_WEEK));
		System.out.println("hour of day: " + gc.get(Calendar.HOUR_OF_DAY));
		System.out.println("minute: " + gc.get(Calendar.MINUTE));
		gc.set(Calendar.DAY_OF_MONTH, 1); // set day of month to 1
		System.out.println(gc.getTime());
		gc.set(2004, 0, 7, 15, 40); // set time to January 7, 2004 at 15:40 (the month is zero-based)
		System.out.println(gc.getTime());
	}

}
