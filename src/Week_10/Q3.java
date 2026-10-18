package Week_10;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().replace("[", "").replace("]", "").trim();

        int even = 0, odd = 0;
        if (!line.isEmpty()) {
            String[] parts = line.split(",");
            for (String part : parts) {
                int num = Integer.parseInt(part.trim());
                if (num % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
        }

        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
        sc.close();
    }
}
