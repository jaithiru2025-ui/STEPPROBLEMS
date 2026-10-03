package Week_09;

import java.util.*;

abstract class Booking {
    private static final double BOOKING_FEE = 50.0;

    protected double distance;

    Booking(double distance) {
        this.distance = distance;
    }

    abstract double baseFare();

    final double totalFare() {
        return baseFare() + BOOKING_FEE;
    }
}

class BusBooking extends Booking {
    BusBooking(double distance) { super(distance); }

    @Override
    double baseFare() { return 2.0 * distance; }
}

class TrainBooking extends Booking {
    TrainBooking(double distance) { super(distance); }

    @Override
    double baseFare() { return 1.5 * distance; }
}

class FlightBooking extends Booking {
    FlightBooking(double distance) { super(distance); }

    @Override
    double baseFare() { return 2500.0 + 4.0 * distance; }
}

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Booking> bookings = new ArrayList<>();
        List<String> modes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String mode = sc.next().toUpperCase();
            double distance = sc.nextDouble();
            modes.add(mode);
            switch (mode) {
                case "BUS": bookings.add(new BusBooking(distance)); break;
                case "TRAIN": bookings.add(new TrainBooking(distance)); break;
                default: bookings.add(new FlightBooking(distance));
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(modes.get(i) + ": " + String.format(Locale.US, "%.2f", bookings.get(i).totalFare()));
        }
    }
}