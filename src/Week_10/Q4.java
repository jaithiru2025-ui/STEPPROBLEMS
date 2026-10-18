package Week_10;

import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().replace("[", "").replace("]", "").trim();

        String[] parts = line.split(",");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i].trim());
        }

        // Two pointers: swap and move toward the centre (no second array)
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        StringBuilder out = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            out.append(arr[i]);
            if (i < arr.length - 1) out.append(", ");
        }
        out.append("]");
        System.out.println(out);
        sc.close();
    }
}