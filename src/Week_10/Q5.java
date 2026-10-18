package Week_10;

import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sum = 0;
        int reversed = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            reversed = reversed * 10 + digit;
            n = n / 10;
        }

        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reversed);
        sc.close();
    }
}