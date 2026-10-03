package Week_09;

import java.util.*;

abstract class StaffMember {
    protected String name;

    StaffMember(String name) {
        this.name = name;
    }

    String getName() { return name; }

    abstract double pay();
}

class FullTimeStaff extends StaffMember {
    private double weeklySalary;

    FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    double pay() { return weeklySalary; }
}

class HourlyStaff extends StaffMember {
    private double hours, rate;

    HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    double pay() {
        if (hours <= 40) return hours * rate;
        return 40 * rate + (hours - 40) * rate * 1.5;
    }
}

class InternStaff extends StaffMember {
    private double stipend;

    InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    double pay() { return stipend; }
}

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<StaffMember> staff = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            switch (type) {
                case "FULLTIME":
                    staff.add(new FullTimeStaff(name, sc.nextDouble()));
                    break;
                case "HOURLY":
                    staff.add(new HourlyStaff(name, sc.nextDouble(), sc.nextDouble()));
                    break;
                default:
                    staff.add(new InternStaff(name, sc.nextDouble()));
            }
        }

        double total = 0;
        for (StaffMember s : staff) {
            double p = s.pay();
            total += p;
            System.out.println(s.getName() + ": " + String.format(Locale.US, "%.2f", p));
        }
        System.out.println("Total Payroll: " + String.format(Locale.US, "%.2f", total));
    }
}