package mg.itu.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FrontUtils {

   public static String dateFormater(LocalDateTime date){
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy à HH:mm", Locale.FRENCH);
       return date.format(formatter);
   }

   public static String dateFormater(LocalDate date){
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.FRENCH);
       return date.format(formatter);
   }

    public static String priceFormater(double price) {
        return String.format(Locale.FRENCH, "%,.2f", price)+" Ar";
    }
}
