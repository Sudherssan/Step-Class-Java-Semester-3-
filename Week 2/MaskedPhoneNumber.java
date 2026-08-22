import java.util.Scanner;

public class MaskedPhoneNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 10-digit phone number: ");
        String phone = sc.nextLine();

        boolean valid = true;

        if (phone.length() != 10) {
            valid = false;
        } else {

            for (int i = 0; i < phone.length(); i++) {

                if (!Character.isDigit(phone.charAt(i))) {
                    valid = false;
                    break;
                }
            }
        }

        if (valid) {

            StringBuilder maskedNumber = new StringBuilder();

            maskedNumber.append("XXXXXX-");
            maskedNumber.append(phone.substring(6));

            System.out.println("Masked Number: " + maskedNumber);

        } else {
            System.out.println("Invalid phone number");
        }

        sc.close();
    }
}