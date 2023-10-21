import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        // user input for local time zone
        System.out.print("Enter your Local Time Zone: \n(e.g. Asia/Kolkata, Asia/Tashkent, Asia/Kuwait): ");
        String LZId = sc.nextLine();
        ZoneId localId = ZoneId.of(LZId);

        // user input for country time zone
        System.out.print("Enter the country time zone \n(e.g. America/New_York, Europe/London, Asia/Tokyo): ");
        String CZId = sc.nextLine();
        ZoneId countryId = ZoneId.of(CZId);

        // Convert local time to country time
        LocalDateTime localDateTime = LocalDateTime.now(localId);
        LocalDateTime countryDateTime = localDateTime.atZone(localId).withZoneSameInstant(countryId).toLocalDateTime();

        // Formating Date and time

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String localTime = formatter.format(localDateTime);
            String countryTime = formatter.format(countryDateTime);

        // Showing output

        System.out.println("Local Time (" + localId + "): " + localTime);
        System.out.println("Country Time (" + countryId + "): " + countryTime);
        sc.close();;

    }
}