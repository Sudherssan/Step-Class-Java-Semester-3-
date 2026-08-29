import java.util.Scanner;

public class Login {

    static void simulateLogin(String correctCode, String[] attempts) {
        boolean accessGranted = false;

        for (int i = 0; i < attempts.length; i++) {
            if (attempts[i].equals(correctCode)) {
                System.out.println("Access granted on attempt " + (i + 1));
                accessGranted = true;
                break;
            }
        }

        if (!accessGranted) {
            System.out.println("Access denied — all attempts used");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String correctCode = sc.nextLine();
        int n = sc.nextInt();
        sc.nextLine();

        String[] attempts = new String[n];

        for (int i = 0; i < n; i++) {
            attempts[i] = sc.nextLine();
        }

        simulateLogin(correctCode, attempts);

        sc.close();
    }
}