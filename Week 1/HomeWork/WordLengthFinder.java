import java.util.Scanner;

public class WordLengthFinder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        String[] words = sentence.split("\\s+");

        String shortest = words[0];
        String longest = words[0];

        for (int i = 1; i < words.length; i++) {

            if (words[i].length() < shortest.length()) {
                shortest = words[i];
            }

            if (words[i].length() > longest.length()) {
                longest = words[i];
            }
        }

        System.out.println("\nWord Analysis");
        System.out.println("=============");
        System.out.println("Shortest Word : " + shortest);
        System.out.println("Character Count: " + shortest.length());

        System.out.println("\nLongest Word  : " + longest);
        System.out.println("Character Count: " + longest.length());

        sc.close();
    }
}