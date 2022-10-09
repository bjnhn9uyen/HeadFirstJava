package extra_Internationalization_Localization;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class FormattingMessageByPattern {

    public static void main(String[] args) {
        String language = "en";
        String country = "US";
        Locale currentLocale = new Locale(language, country);
        String baseName = FormattingMessageByPattern.class.getPackage().getName()
                          + "/resources/MessagesBundle_en_US";
        ResourceBundle resourceBundle = ResourceBundle.getBundle(baseName, currentLocale);
        // You can use your own defined Locale or you can use the constants of Locale class
//		ResourceBundle resourceBundle = ResourceBundle.getBundle(baseName, Locale.US);

        // apply the pattern to the MessageFormat instance
        MessageFormat formatter = new MessageFormat(resourceBundle.getString("pattern"), currentLocale);
//		formatter.applyPattern(resourceBundle.getString("pattern")); // another way to apply the pattern

        // variables in the message bundle sequentially are: time, date, number of spaceships, planet's name
        Object[] messageArguments = {resourceBundle.getString("planet"), 7, new Date()};
        String formattedStr = formatter.format(messageArguments);
        System.out.println(formattedStr);
    }

}
