import java.util.*;

class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + "}";
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Rahul", 28, 50000));
        employees.add(new Employee("Rajesh", 25, 70000));
        employees.add(new Employee("Danish", 25, 60000));
        employees.add(new Employee("Rakesh", 30, 75000));

        System.out.println("Sorted by name:");
        employees.sort((emp1, emp2) -> emp1.name.compareTo(emp2.name));
        employees.forEach(System.out::println);

        System.out.println("\nSorted by age:");
        employees.sort((emp1, emp2) -> Integer.compare(emp1.age, emp2.age));
        employees.forEach(System.out::println);

        System.out.println("\nSorted by salary:");
        employees.sort((emp1, emp2) -> Double.compare(emp1.salary, emp2.salary));
        employees.forEach(System.out::println);
    }
}
