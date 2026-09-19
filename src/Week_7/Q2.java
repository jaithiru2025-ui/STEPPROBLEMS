package Week_7;

class Scorecard {
    private final boolean[] results;
    private int answeredCount;

    Scorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
        answeredCount = 0;
    }

    void recordAnswer(boolean isCorrect) {
        if (answeredCount < results.length) {
            results[answeredCount] = isCorrect;
            answeredCount++;
        }
        // if already at max questions, ignore further calls
    }

    int getScore() {
        int score = 0;
        for (int i = 0; i < answeredCount; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }
}

public class Q2 {
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score: " + sc.getScore());
    }
}