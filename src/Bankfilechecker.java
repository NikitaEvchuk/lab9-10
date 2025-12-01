import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class Bankfilechecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the first three digits of the bank account number:");
        String userPrefix = scanner.next();

        String nbpUrl = "https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt";

        try {
            URL url = new URL(nbpUrl);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            try (BufferedReader readerbank = new BufferedReader(new InputStreamReader(url.openStream()))) {

                String line;
                boolean found = false;

                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    if (line.isEmpty()) continue;

                    String[] parts = line.split("\\s+", 2);

                    if (parts.length >= 2) {
                        String bankCode = parts[0];
                        String bankName = parts[1];
                        if (bankCode.startsWith(userPrefix)) {
                            System.out.println("--- Result ---");
                            System.out.println("Abbreviated bank number: " + bankCode);
                            System.out.println("Name of the bank: " + bankName);
                            found = true;
                            break;
                        }
                    }
                }

                if (!found) {
                    System.out.println("No bank found starting with the digits: " + userPrefix);
                }
            }
        } catch (IOException e) {
            System.out.println(" Could not download data from NBP.");
            e.printStackTrace();
        }
    }
}