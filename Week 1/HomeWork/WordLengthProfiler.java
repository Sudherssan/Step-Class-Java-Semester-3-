import java.util.Scanner;

public class WordLengthProfiler {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter movie review: ");
        String review = sc.nextLine();

        String[] words = review.split("\\s+");

        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (int i = 0; i < words.length; i++) {

            // Remove punctuation from the word
            String word = words[i].replaceAll("[^a-zA-Z]", "");

            int length = word.length();

            if (length >= 1 && length <= 4) {
                shortCount++;
            } else if (length >= 5 && length <= 8) {
                mediumCount++;
            } else if (length >= 9) {
                longCount++;
            }
        }

        System.out.println("\nWord Length Profile");
        System.out.println("===================");
        System.out.println("Short Words  (1-4)  : " + shortCount);
        System.out.println("Medium Words (5-8)  : " + mediumCount);
        System.out.println("Long Words   (9+)   : " + longCount);

        sc.close();
    }
}