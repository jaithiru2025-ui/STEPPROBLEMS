package Week_10;

import java.util.Scanner;

public class Q7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            long factorial = 1;      // also covers 0! = 1

            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }

            System.out.println(factorial);
        }
        sc.close();
    }
}