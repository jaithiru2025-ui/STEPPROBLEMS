package Week_08;

import java.util.*;

abstract class Delivery {
    protected double weight, distance;

    Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    abstract double fee();
}

class StandardDelivery extends Delivery {
    StandardDelivery(double w, double d) { super(w, d); }

    @Override
    double fee() { return 5 + 0.50 * weight + 0.10 * distance; }
}

class ExpressDelivery extends Delivery {
    ExpressDelivery(double w, double d) { super(w, d); }

    @Override
    double fee() { return 15 + 1.00 * weight + 0.20 * distance; }
}

class InternationalDelivery extends Delivery {
    private double customsFee;

    InternationalDelivery(double w, double d, double customsFee) {
        super(w, d);
        this.customsFee = customsFee;
    }

    @Override
    double fee() { return 25 + 2.00 * weight + 0.50 * distance + customsFee; }
}

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Delivery> deliveries = new ArrayList<>();
        List<String> names = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            String type = p[0].toUpperCase();
            double w = Double.parseDouble(p[1]);
            double d = Double.parseDouble(p[2]);
            names.add(type);
            switch (type) {
                case "STANDARD": deliveries.add(new StandardDelivery(w, d)); break;
                case "EXPRESS": deliveries.add(new ExpressDelivery(w, d)); break;
                default: deliveries.add(new InternationalDelivery(w, d, Double.parseDouble(p[3])));
            }
        }

        double total = 0;
        for (int i = 0; i < n; i++) {
            double f = deliveries.get(i).fee();
            total += f;
            System.out.println(names.get(i) + ": " + String.format(Locale.US, "%.2f", f));
        }
        System.out.println("Total: " + String.format(Locale.US, "%.2f", total));
    }
}