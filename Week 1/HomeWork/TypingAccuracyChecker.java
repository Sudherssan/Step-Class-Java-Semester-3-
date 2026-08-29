import java.util.Scanner;

public class TypingAccuracyChecker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter original text: ");
        String original = sc.nextLine();

        System.out.print("Enter typed text: ");
        String typed = sc.nextLine();

        int minLength = Math.min(original.length(), typed.length());
        int matchCount = 0;
        int firstMismatch = -1;

        for (int i = 0; i < minLength; i++) {

            if (original.charAt(i) == typed.charAt(i)) {
                matchCount++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        // If one string is longer, the first extra character is a mismatch
        if (firstMismatch == -1 && original.length() != typed.length()) {
            firstMismatch = minLength;
        }

        double accuracy = ((double) matchCount / original.length()) * 100;

        System.out.println("\nTyping Accuracy Report");
        System.out.println("======================");
        System.out.println("Matching Characters : " + matchCount);
        System.out.println("Accuracy             : " + accuracy + "%");

        if (firstMismatch == -1) {
            System.out.println("First Mismatch Index : None");
        } else {
            System.out.println("First Mismatch Index : " + firstMismatch);
        }

        sc.close();
    }
}
