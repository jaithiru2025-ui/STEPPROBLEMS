package Week_7;

class AttendanceSheet {
    private final String[] presentStudents;
    private int presentCount;

    AttendanceSheet(int maxClassSize) {
        presentStudents = new String[maxClassSize];
        presentCount = 0;
    }

    void markPresent(String name) {
        if (isPresent(name)) {
            return; // already marked, avoid duplicate
        }
        if (presentCount < presentStudents.length) {
            presentStudents[presentCount] = name;
            presentCount++;
        }
    }

    int getPresentCount() {
        return presentCount;
    }

    boolean isPresent(String name) {
        for (int i = 0; i < presentCount; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }
}

public class Q5 {
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana"); // duplicate, ignored

        System.out.println("Present count: " + sheet.getPresentCount());
        System.out.println("isPresent(\"Ben\"): " + sheet.isPresent("Ben"));
        System.out.println("isPresent(\"Chen\"): " + sheet.isPresent("Chen"));
    }
}