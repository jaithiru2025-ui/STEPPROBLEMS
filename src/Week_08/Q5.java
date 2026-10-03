package Week_08;

import java.util.*;

abstract class Journey {
    protected double distance;

    Journey(double distance) {
        this.distance = distance;
    }

    abstract double fare();
}

class Bus extends Journey {
    Bus(double d) { super(d); }

    @Override
    double fare() { return Math.min(2 + 0.10 * distance, 10); }
}

class Train extends Journey {
    Train(double d) { super(d); }

    @Override
    double fare() { return 3 + 0.15 * distance; }
}

class Metro extends Journey {
    private double peakFactor;

    Metro(double d, double peakFactor) {
        super(d);
        this.peakFactor = peakFactor;
    }

    @Override
    double fare() { return (1.50 + 0.20 * distance) * peakFactor; }
}

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Journey> journeys = new ArrayList<>();
        List<String> names = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            String type = p[0].toUpperCase();
            double d = Double.parseDouble(p[1]);
            names.add(type);
            switch (type) {
                case "BUS": journeys.add(new Bus(d)); break;
                case "TRAIN": journeys.add(new Train(d)); break;
                default: journeys.add(new Metro(d, Double.parseDouble(p[2])));
            }
        }

        double total = 0;
        for (int i = 0; i < n; i++) {
            double f = journeys.get(i).fare();
            total += f;
            System.out.println(names.get(i) + ": " + String.format(Locale.US, "%.2f", f));
        }
        System.out.println("Total: " + String.format(Locale.US, "%.2f", total));
    }
}