package Week_09;

import java.util.*;

abstract class Plot {
    protected String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    String getOwner() { return owner; }

    abstract double area();
}

class CirclePlot extends Plot {
    private double radius;

    CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    @Override
    double area() { return Math.PI * radius * radius; }
}

class RectanglePlot extends Plot {
    private double length, width;

    RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    @Override
    double area() { return length * width; }
}

class TrianglePlot extends Plot {
    private double base, height;

    TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    @Override
    double area() { return 0.5 * base * height; }
}

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Plot> plots = new ArrayList<>();
        List<String> shapes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String shape = sc.next().toUpperCase();
            String owner = sc.next();
            shapes.add(shape);
            switch (shape) {
                case "CIRCLE":
                    plots.add(new CirclePlot(owner, sc.nextDouble()));
                    break;
                case "RECTANGLE":
                    plots.add(new RectanglePlot(owner, sc.nextDouble(), sc.nextDouble()));
                    break;
                default:
                    plots.add(new TrianglePlot(owner, sc.nextDouble(), sc.nextDouble()));
            }
        }

        double total = 0;
        for (int i = 0; i < n; i++) {
            Plot p = plots.get(i);
            double a = p.area();
            total += a;
            System.out.println(p.getOwner() + " (" + shapes.get(i) + "): " + String.format(Locale.US, "%.2f", a));
        }
        System.out.println("Total Area: " + String.format(Locale.US, "%.2f", total));
    }
}