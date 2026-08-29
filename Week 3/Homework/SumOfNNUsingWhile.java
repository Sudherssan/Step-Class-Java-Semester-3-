import java.util.Scanner;

public class SumOfNNUsingWhile {

    static void sumOfNaturalNumbers(int n) {
        int counter = 1;
        int sum = 0;

        while (counter <= n) {
            sum = sum + counter;
            counter++;
        }

        System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        System.out.println("Sum of natural numbers up to " + n + ":");
        sumOfNaturalNumbers(n);

        sc.close();
    }
}