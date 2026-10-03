package Week_08;

import java.util.*;
import java.util.regex.*;

abstract class Question {
    protected String text, correct, student;
    protected int points;

    Question(String text, String correct, String student, int points) {
        this.text = text;
        this.correct = correct;
        this.student = student;
        this.points = points;
    }

    abstract double score();
}

class MCQ extends Question {
    MCQ(String t, String c, String s, int p) { super(t, c, s, p); }

    @Override
    double score() { return student.equals(correct) ? points : 0; }
}

class TrueFalse extends Question {
    TrueFalse(String t, String c, String s, int p) { super(t, c, s, p); }

    @Override
    double score() { return student.equals(correct) ? points : 0; }
}

class Essay extends Question {
    Essay(String t, String c, String s, int p) { super(t, c, s, p); }

    @Override
    double score() {
        String answer = student.toLowerCase();
        int hits = 0;
        for (String k : correct.split(",")) {
            String keyword = k.trim().toLowerCase();
            if (!keyword.isEmpty() && answer.contains(keyword)) hits++;
        }
        if (hits >= 2) return points * 0.75;
        if (hits == 1) return points * 0.50;
        return 0;
    }
}

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Question> questions = new ArrayList<>();
        List<String> names = new ArrayList<>();
        Pattern quoted = Pattern.compile("\"([^\"]*)\"");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String type = line.split("\\s+")[0].toUpperCase();
            int points = Integer.parseInt(line.substring(line.lastIndexOf(' ') + 1).trim());

            Matcher m = quoted.matcher(line);
            m.find(); String text = m.group(1);
            m.find(); String correct = m.group(1);
            m.find(); String student = m.group(1);

            names.add(type);
            switch (type) {
                case "MCQ": questions.add(new MCQ(text, correct, student, points)); break;
                case "TF": questions.add(new TrueFalse(text, correct, student, points)); break;
                default: questions.add(new Essay(text, correct, student, points));
            }
        }

        double total = 0;
        for (int i = 0; i < n; i++) {
            double s = questions.get(i).score();
            total += s;
            System.out.println(names.get(i) + ": " + String.format(Locale.US, "%.2f", s));
        }
        System.out.println("Total Score: " + String.format(Locale.US, "%.2f", total));
    }
}