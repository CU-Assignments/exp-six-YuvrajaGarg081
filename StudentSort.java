import java.util.*;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }
    public String toString() {
        return "Student{name='" + name + "', marks=" + marks + "}";
    }
}

public class StudentSort {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Rahul", 85.5),
                new Student("Rakesh", 72.3),
                new Student("Partik", 90.0),
                new Student("Raman", 65.4),
                new Student("Rohit", 80.2),
                new Student("Dinesh", 95.6)
        );
        System.out.println("Students scoring above 75%, sorted by marks:");

        students.stream()
                .filter(student -> student.getMarks() > 75)
                .sorted(Comparator.comparingDouble(Student::getMarks).reversed())
                .map(Student::getName)
                .forEach(System.out::println);
    }
}
