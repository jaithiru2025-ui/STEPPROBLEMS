package Week_08;

import java.time.LocalDate;
import java.util.*;

abstract class LibraryItem {
    protected String title;
    static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int borrowDays();

    LocalDate dueDate() {
        return CURRENT_DATE.plusDays(borrowDays());
    }

    String getTitle() { return title; }
}

class Book extends LibraryItem {
    Book(String title) { super(title); }

    @Override
    int borrowDays() { return 14; }
}

class DVD extends LibraryItem {
    DVD(String title) { super(title); }

    @Override
    int borrowDays() { return 7; }
}

class Magazine extends LibraryItem {
    Magazine(String title) { super(title); }

    @Override
    int borrowDays() { return 3; }
}

public class Q2 {
    static LibraryItem create(String type, String title) {
        switch (type.toUpperCase()) {
            case "BOOK": return new Book(title);
            case "DVD": return new DVD(title);
            default: return new Magazine(title);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int space = line.indexOf(' ');
            String type = line.substring(0, space);
            String title = line.substring(space + 1).trim();
            if (title.startsWith("\"") && title.endsWith("\"") && title.length() >= 2) {
                title = title.substring(1, title.length() - 1);
            }
            items.add(create(type, title));
        }

        for (LibraryItem item : items) {
            System.out.println(item.getTitle() + ": " + item.dueDate());
        }
    }
}
