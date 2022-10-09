package extra_Internationalization_Localization;

import java.text.NumberFormat;
import java.util.Locale;

public class FormattingNumberByLocale {

    public static void main(String[] args) {
        System.out.println("number in US format:");
        formatNumberByLocale("en", "US"); // ‘en’ is language code, ‘US’ is country code
        
        System.out.println("number in Germany format:");
        formatNumberByLocale("de", "DE");

        System.out.println("number in France format:");
        formatNumberByLocale("fr", "FR");

        System.out.println("number in Japan format:");
        formatNumberByLocale("ja", "JP");
    }

    private static void formatNumberByLocale(String language, String country) {
        Locale locale = new Locale(language, country);
        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
        String integerFomatted = numberFormat.format(123456); // format an integer number
        String doubleFomatted = numberFormat.format(345987.246); // format a double number
        System.out.println(integerFomatted);
        System.out.println(doubleFomatted + "\n");
    }

}
