package Week_08;

import java.util.*;

abstract class Payment {
    protected double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract double finalAmount();
}

class CardPayment extends Payment {
    CardPayment(double amount) { super(amount); }

    @Override
    double finalAmount() { return amount * 1.02; }
}

class WalletPayment extends Payment {
    WalletPayment(double amount) { super(amount); }

    @Override
    double finalAmount() { return amount * 1.01; }
}

class BankTransferPayment extends Payment {
    BankTransferPayment(double amount) { super(amount); }

    @Override
    double finalAmount() { return amount; }
}

public class Q1 {
    static Payment create(String type, double amount) {
        switch (type.toUpperCase()) {
            case "CARD": return new CardPayment(amount);
            case "WALLET": return new WalletPayment(amount);
            default: return new BankTransferPayment(amount);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Payment> payments = new ArrayList<>();
        List<String> names = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double amount = sc.nextDouble();
            names.add(type);
            payments.add(create(type, amount));
        }

        double total = 0;
        for (int i = 0; i < n; i++) {
            double result = payments.get(i).finalAmount();
            total += result;
            System.out.println(names.get(i) + ": " + String.format(Locale.US, "%.2f", result));
        }
        System.out.println("Total: " + String.format(Locale.US, "%.2f", total));
    }
}