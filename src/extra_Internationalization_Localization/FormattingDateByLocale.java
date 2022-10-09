package extra_Internationalization_Localization;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class FormattingDateByLocale {

    public static void main(String[] args) {
        System.out.println("date in US format:");
        formatDateByLocale("en", "US"); // ‘en’ is language code, ‘US’ is country code

        System.out.println("\ndate in Germany format:");
        formatDateByLocale("de", "DE");

        System.out.println("\ndate in France format:");
        formatDateByLocale("fr", "FR");

        System.out.println("\ndate in Japan format:");
        formatDateByLocale("ja", "JP");
    }

    private static void formatDateByLocale(String language, String country) {
        Locale locale = new Locale(language, country);
        Date today = new Date();

        DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT, locale);
        DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.SHORT, locale);
        String strDate = dateFormatter.format(today);
        String strTime = timeFormatter.format(today);
        System.out.println("short style date: " + strDate + " time: " + strTime);

        dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
        timeFormatter = DateFormat.getTimeInstance(DateFormat.MEDIUM, locale);
        strDate = dateFormatter.format(today);
        strTime = timeFormatter.format(today);
        System.out.println("medium style date: " + strDate + " time: " + strTime);

        dateFormatter = DateFormat.getDateInstance(DateFormat.LONG, locale);
        timeFormatter = DateFormat.getTimeInstance(DateFormat.LONG, locale);
        strDate = dateFormatter.format(today);
        strTime = timeFormatter.format(today);
        System.out.println("long style date: " + strDate + " time: " + strTime);

        dateFormatter = DateFormat.getDateInstance(DateFormat.FULL, locale);
        timeFormatter = DateFormat.getTimeInstance(DateFormat.FULL, locale);
        strDate = dateFormatter.format(today);
        strTime = timeFormatter.format(today);
        System.out.println("full style date: " + strDate + " time: " + strTime);
    }

}
