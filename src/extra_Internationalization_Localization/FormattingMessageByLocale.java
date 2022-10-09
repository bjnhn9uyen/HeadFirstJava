package extra_Internationalization_Localization;

import java.util.Locale;
import java.util.ResourceBundle;

public class FormattingMessageByLocale {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("messages in English:");
        setBaseAndLocale("MessagesBundle_en_US", Locale.US); // ‘en’ is language code, ‘US’ is country code

        System.out.println("messages in German:");
        setBaseAndLocale("MessagesBundle_de_DE", Locale.GERMANY);

        System.out.println("messages in French:");
        setBaseAndLocale("MessagesBundle_fr_FR", Locale.FRANCE);

        System.out.println("messages in Japanese:");
        setBaseAndLocale("MessagesBundle_ja_JP", Locale.JAPAN);

        System.out.println("messages in default language:");
        Locale.setDefault(new Locale("vi", "VN"));
        setBaseAndLocale("MessagesBundle", Locale.getDefault());
    }

    private static void setBaseAndLocale(String baseName, Locale locale) {
        ResourceBundle rb = ResourceBundle.getBundle(FormattingMessageByLocale.class.getPackage().getName()
                                                     + "/resources/" + baseName, locale);
        System.out.println("Greeting in '" + locale + "': " + rb.getString("greetings"));
        System.out.println("Farewell in '" + locale + "': " + rb.getString("farewell"));
        System.out.println("Inquiry in '" + locale + "': " + rb.getString("inquiry") + "\n");
    }

}
