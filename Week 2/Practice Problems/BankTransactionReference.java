import java.util.Scanner;

public class BankTransactionReference {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter transaction reference: ");
        String reference = sc.nextLine().trim();

        // Check length
        if (reference.length() != 14) {
            System.out.println("Invalid Reference");
            sc.close();
            return;
        }

        // Convert bank code to uppercase
        String bankCode = reference.substring(0, 3).toUpperCase();

        // Check bank code contains only letters
        boolean validPrefix = true;

        for (int i = 0; i < 3; i++) {

            char ch = reference.charAt(i);

            if (!Character.isLetter(ch)) {
                validPrefix = false;
                break;
            }
        }

        // Check date and sequence contain only digits
        boolean validDigits = true;

        for (int i = 3; i < 14; i++) {

            char ch = reference.charAt(i);

            if (!Character.isDigit(ch)) {
                validDigits = false;
                break;
            }
        }

        if (validPrefix && validDigits) {

            String date = reference.substring(3, 9);
            String sequence = reference.substring(9);

            String formattedDate =
                    date.substring(0, 2) + "/" +
                    date.substring(2, 4) + "/" +
                    date.substring(4, 6);

            System.out.println("\nTransaction Reference");
            System.out.println("=====================");
            System.out.println("[" + bankCode + "] DATE: " +
                               formattedDate + " | SEQ: " + sequence);

        } else {
            System.out.println("Invalid Reference");
        }

        sc.close();
    }
}
