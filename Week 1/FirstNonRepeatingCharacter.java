import java.util.HashMap;
import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word or sentence: ");
        String text = sc.nextLine();

        HashMap<Character, Integer> frequency = new HashMap<>();

        // Count frequency of each character
        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (ch != ' ') {
                frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
            }
        }

        char result = '\0';

        // Find first non-repeating character
        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (ch != ' ' && frequency.get(ch) == 1) {
                result = ch;
                break;
            }
        }

        if (result != '\0') {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }

        sc.close();
    }
}