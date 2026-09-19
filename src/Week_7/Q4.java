package Week_7;

class Locker {
    private final int lockerNumber;
    private String code;

    Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    // Write-only: no getter for the code exists anywhere in this class
    boolean changeCode(String currentCode, String newCode) {
        if (currentCode.equals(code)) {
            code = newCode;
            return true;
        }
        return false; // rejected, code stays the same
    }

    int getLockerNumber() {
        return lockerNumber;
    }
}

public class Q4 {
    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");

        boolean result1 = l.changeCode("1234", "5678");
        System.out.println("changeCode(\"1234\", \"5678\") success: " + result1);

        boolean result2 = l.changeCode("0000", "9999");
        System.out.println("changeCode(\"0000\", \"9999\") success: " + result2);
    }
}