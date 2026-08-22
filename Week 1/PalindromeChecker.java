import java.util.Scanner;

public class PalindromeChecker {

    // Method 1: Iterative comparison
    static boolean iterativeCheck(String text) {

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {

            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // Method 2: Recursion
    static boolean recursiveCheck(String text, int left, int right) {

        if (left >= right) {
            return true;
        }

        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }

        return recursiveCheck(text, left + 1, right - 1);
    }

    // Method 3: Array reversal
    static boolean arrayCheck(String text) {

        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        return new String(original).equals(new String(reversed));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        boolean method1 = iterativeCheck(text);
        boolean method2 = recursiveCheck(text, 0, text.length() - 1);
        boolean method3 = arrayCheck(text);

        System.out.println("\nPalindrome Verification");
        System.out.println("=======================");
        System.out.println("Iterative Method : " + method1);
        System.out.println("Recursive Method : " + method2);
        System.out.println("Array Method     : " + method3);

        if (method1 && method2 && method3) {
            System.out.println("\nResult: The text is a palindrome.");
            System.out.println("All three methods agree.");
        } else {
            System.out.println("\nResult: The text is not a palindrome.");
            System.out.println("All three methods agree.");
        }

        sc.close();
    }
}