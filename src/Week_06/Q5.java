package Week_06;

public class Q5 {
    public static void main(String[] args) {
        CollegeStudent s1 = new CollegeStudent("Divya", 92);
        CollegeStudent s2 = new CollegeStudent("Arjun", 88);

        CollegeStudent.printCollegeInfo();
    }
}

class CollegeStudent {
    String name;
    int attendance;

    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    public CollegeStudent(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}