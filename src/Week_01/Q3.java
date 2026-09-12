package Week_01;

public class Q3 {
    public static void main(String[] args) {
        double[] heights = {1.75, 1.60, 1.80, 1.65, 1.70, 1.68, 1.72, 1.90, 1.55, 1.77};
        double[] weights = {70, 90, 75, 58, 65, 80, 68, 95, 50, 72};

        printWellnessReport(heights, weights);
    }

    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }

    static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person | Height (m) | Weight (kg) | BMI | Status");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            double roundedBmi = Math.round(bmi * 100.0) / 100.0;

            System.out.println("Person " + (i + 1) + " | " + heights[i] + " | " + weights[i] +
                    " | " + roundedBmi + " | " + status);
        }
    }
}