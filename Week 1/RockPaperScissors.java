import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.print("Enter number of rounds: ");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.println("\nRound | Player Move | Computer Move | Result");
        System.out.println("--------------------------------------------");

        for (int i = 1; i <= n; i++) {

            System.out.print("Round " + i + " - Enter Rock, Paper or Scissors: ");
            String playerMove = sc.nextLine();

            int computerIndex = random.nextInt(3);
            String computerMove = moves[computerIndex];

            String result;

            if (playerMove.equalsIgnoreCase(computerMove)) {
                result = "Draw";
                draws++;
            }
            else if (
                (playerMove.equalsIgnoreCase("Rock") && computerMove.equals("Scissors")) ||
                (playerMove.equalsIgnoreCase("Paper") && computerMove.equals("Rock")) ||
                (playerMove.equalsIgnoreCase("Scissors") && computerMove.equals("Paper"))
            ) {
                result = "Win";
                wins++;
            }
            else {
                result = "Loss";
                losses++;
            }

            System.out.printf("%5d | %-11s | %-14s | %s%n",
                    i, playerMove, computerMove, result);
        }

        double winPercentage = ((double) wins / n) * 100;

        System.out.println("\nGame Summary");
        System.out.println("============");
        System.out.println("Wins           : " + wins);
        System.out.println("Losses         : " + losses);
        System.out.println("Draws          : " + draws);
        System.out.println("Win Percentage : " + winPercentage + "%");

        sc.close();
    }
}