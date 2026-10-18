package Week_10;

import java.util.Scanner;

class Student {
    private String name;
    private int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double calculateAverage() {
        int total = 0;
        for (int m : marks) {
            total += m;
        }
        return (double) total / marks.length;
    }

    String getGrade() {
        double avg = calculateAverage();
        if (avg >= 90) {
            return "A";
        } else if (avg >= 75) {
            return "B";
        } else if (avg >= 60) {
            return "C";
        } else if (avg >= 40) {
            return "D";
        } else {
            return "F";
        }
    }

    void printResult() {
        System.out.println(String.format("%s: Average %.1f, Grade %s",
                name.toUpperCase(), calculateAverage(), getGrade()));
    }
}

public class Q10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            int bracket = line.indexOf('[');
            String name = line.substring(0, bracket).trim();
            String[] parts = line.substring(bracket + 1, line.indexOf(']')).split(",");

            int[] marks = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                marks[i] = Integer.parseInt(parts[i].trim());
            }

            new Student(name, marks).printResult();
        }
        sc.close();
    }
}