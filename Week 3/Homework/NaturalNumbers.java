import java.util.Scanner;

public class NaturalNumbers {

    static void printNumbersUpToN(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println("Natural numbers up to " + n + ":");
        printNumbersUpToN(n);

        sc.close();
    }
}