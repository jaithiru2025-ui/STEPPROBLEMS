package Week_09;

import java.util.*;

abstract class BorrowedItem {
    protected String title;
    protected int daysLate;

    BorrowedItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    String getTitle() { return title; }

    abstract double fine();
}

class BookItem extends BorrowedItem {
    BookItem(String title, int daysLate) { super(title, daysLate); }

    @Override
    double fine() { return 2.0 * daysLate; }
}

class DvdItem extends BorrowedItem {
    DvdItem(String title, int daysLate) { super(title, daysLate); }

    @Override
    double fine() { return Math.min(5.0 * daysLate, 50.0); }
}

class MagazineItem extends BorrowedItem {
    MagazineItem(String title, int daysLate) { super(title, daysLate); }

    @Override
    double fine() { return 1.0 * daysLate; }
}

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<BorrowedItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String title = sc.next();
            int days = sc.nextInt();
            switch (type) {
                case "BOOK": items.add(new BookItem(title, days)); break;
                case "DVD": items.add(new DvdItem(title, days)); break;
                default: items.add(new MagazineItem(title, days));
            }
        }

        double total = 0;
        for (BorrowedItem item : items) {
            double f = item.fine();
            total += f;
            System.out.println(item.getTitle() + ": " + String.format(Locale.US, "%.2f", f));
        }
        System.out.println("Total Fines: " + String.format(Locale.US, "%.2f", total));
    }
}
