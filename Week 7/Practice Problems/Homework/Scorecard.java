
import java.util.*;

public class Scorecard {

    // Private array to store answer results
    private boolean[] results;

    // Tracks the number of answers recorded
    private int answersRecorded;

    // Constructor
    public Scorecard(int totalQuestions) {
        if (totalQuestions < 0) {
            throw new IllegalArgumentException(
                "Total questions cannot be negative"
            );
        }

        results = new boolean[totalQuestions];
        answersRecorded = 0;
    }

    // Record the next answer
    public void recordAnswer(boolean isCorrect) {
        if (answersRecorded >= results.length) {
            System.out.println(
                "Answer rejected: all questions have been recorded"
            );
            return;
        }

        results[answersRecorded] = isCorrect;
        answersRecorded++;
    }

    // Return only the total score
    public int getScore() {
        int score = 0;

        for (int i = 0; i < answersRecorded; i++) {
            if (results[i]) {
                score++;
            }
        }

        return score;
    }

    public static void main(String[] args) {

        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Final score: " + sc.getScore());
    }
}
