package Week_09;

import java.util.*;

abstract class Connection {
    protected double units;

    Connection(double units) {
        this.units = units;
    }

    abstract double bill();
}

class HomeConnection extends Connection {
    HomeConnection(double units) { super(units); }

    @Override
    double bill() {
        if (units <= 100) return 5.0 * units;
        return 5.0 * 100 + 7.0 * (units - 100);
    }
}

class ShopConnection extends Connection {
    ShopConnection(double units) { super(units); }

    @Override
    double bill() { return 8.0 * units + 100.0; }
}

class FactoryConnection extends Connection {
    FactoryConnection(double units) { super(units); }

    @Override
    double bill() { return Math.max(6.0 * units, 1000.0); }
}

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Connection> connections = new ArrayList<>();
        List<String> names = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double units = sc.nextDouble();
            names.add(type);
            switch (type) {
                case "HOME": connections.add(new HomeConnection(units)); break;
                case "SHOP": connections.add(new ShopConnection(units)); break;
                default: connections.add(new FactoryConnection(units));
            }
        }

        double total = 0;
        for (int i = 0; i < n; i++) {
            double b = connections.get(i).bill();
            total += b;
            System.out.println(names.get(i) + ": " + String.format(Locale.US, "%.2f", b));
        }
        System.out.println("Total: " + String.format(Locale.US, "%.2f", total));
    }
}