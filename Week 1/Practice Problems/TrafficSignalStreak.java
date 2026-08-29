import java.util.Scanner;

public class TrafficSignalStreak {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter traffic signal sequence (R/Y/G): ");
        String signals = sc.nextLine();

        char longestColor = signals.charAt(0);
        int longestStreak = 1;

        char currentColor = signals.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < signals.length(); i++) {

            if (signals.charAt(i) == currentColor) {
                currentStreak++;
            } else {

                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                    longestColor = currentColor;
                }

                currentColor = signals.charAt(i);
                currentStreak = 1;
            }
        }

        // Check the final streak
        if (currentStreak > longestStreak) {
            longestStreak = currentStreak;
            longestColor = currentColor;
        }

        System.out.println("\nTraffic Signal Analysis");
        System.out.println("=======================");
        System.out.println("Longest Streak Color : " + longestColor);
        System.out.println("Repetition Length    : " + longestStreak);

        sc.close();
    }
}
