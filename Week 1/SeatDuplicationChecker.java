import java.util.Scanner;

public class SeatDuplicationChecker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of seats: ");
        int n = sc.nextInt();

        int[] seats = new int[n];

        System.out.println("Enter seat numbers:");

        for (int i = 0; i < n; i++) {
            seats[i] = sc.nextInt();
        }

        boolean foundDuplicate = false;

        System.out.println("\nDuplicate Seat Numbers:");

        for (int i = 0; i < n; i++) {

            boolean alreadyPrinted = false;

            // Check if this number appeared before
            for (int k = 0; k < i; k++) {
                if (seats[i] == seats[k]) {
                    alreadyPrinted = true;
                    break;
                }
            }

            if (alreadyPrinted) {
                continue;
            }

            // Check for duplicate
            for (int j = i + 1; j < n; j++) {

                if (seats[i] == seats[j]) {
                    System.out.println(seats[i]);
                    foundDuplicate = true;
                    break;
                }
            }
        }

        if (!foundDuplicate) {
            System.out.println("All seat assignments are unique.");
        }

        sc.close();
    }
}