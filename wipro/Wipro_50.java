package wipro;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

class Employee_8 {
    int id;
    String name;
    String department;
    double salary;

    public Employee_8(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toString() {
        return id + " - " + name + " - " + department + " - " + salary;
    }

    public String getDepartment() { return department; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public int getId() { return id; }
}

public class Wipro_50 {
    public static void main(String[] args) {
        List<Employee_8> employees = Arrays.asList(
            new Employee_8(101, "Ravi", "HR", 50000),
            new Employee_8(102, "Priya", "IT", 60000),
            new Employee_8(103, "Arun", "HR", 55000),
            new Employee_8(104, "Kavya", "IT", 70000),
            new Employee_8(105, "Divya", "Sales", 45000)
        );

        // Q1
        System.out.println("Q1: " + employees.stream().map(Employee_8::getName).collect(toList()));

        // Q2
        System.out.println("Q2: " + employees.stream().filter(e -> e.salary > 55000).collect(toList()));

        // Q3
        System.out.println("Q3: " + employees.stream().filter(e -> e.department.equals("HR")).count());

        // Q4
        System.out.println("Q4: " + employees.stream().sorted(Comparator.comparingDouble(Employee_8::getSalary).reversed()).collect(toList()));

        // Q5
        System.out.println("Q5: " + employees.stream().max(Comparator.comparingDouble(Employee_8::getSalary)));

        // Q6
        System.out.println("Q6: " + employees.stream().mapToDouble(Employee_8::getSalary).average().orElse(0.0));

        // Q7
        System.out.println("Q7: " + employees.stream().map(Employee_8::getName).collect(toList()));

        // Q8
        System.out.println("Q8: " + employees.stream().collect(groupingBy(Employee_8::getDepartment)));

        // Q9
        System.out.println("Q9: " + employees.stream().collect(groupingBy(Employee_8::getDepartment, summingDouble(Employee_8::getSalary))));

        // Q10
        System.out.println("Q10: " + employees.stream()
                .filter(e -> e.department.equals("IT"))
                .sorted(Comparator.comparingDouble(Employee_8::getSalary))
                .map(Employee_8::getName)
                .collect(toList()));

        // Q11
        System.out.println("Q11: " + employees.stream().anyMatch(e -> e.salary < 40000));

        // Q12
        System.out.println("Q12: " + employees.stream().map(Employee_8::getName).collect(joining(", ")));

        // Q13
        System.out.println("Q13: " + employees.stream()
                .sorted(Comparator.comparingDouble(Employee_8::getSalary).reversed())
                .limit(2)
                .collect(toList()));

        // Q14
        System.out.println("Q14: " + employees.stream().skip(2).collect(toList()));

        // Q15
        System.out.println("Q15: " + employees.stream().limit(3).map(Employee_8::getName).collect(toList()));

        // Q16
        System.out.println("Q16: " + employees.stream()
                .filter(e -> e.department.equals("HR"))
                .min(Comparator.comparingDouble(Employee_8::getSalary)));

        // Q17
        System.out.println("Q17: " + employees.stream()
                .collect(partitioningBy(e -> e.salary > 55000)));

        // Q18
        System.out.println("Q18: " + employees.stream()
                .collect(groupingBy(Employee_8::getDepartment, averagingDouble(Employee_8::getSalary))));

        // Q19
        System.out.println("Q19: " + employees.stream()
                .sorted(Comparator.comparing(Employee_8::getName).thenComparing(Employee_8::getSalary))
                .collect(toList()));

        // Q20
        System.out.println("Q20: " + employees.stream()
                .collect(toMap(Employee_8::getId, Employee_8::getName)));

        // Challenge 1
        System.out.println("Challenge 1: " + employees.stream()
                .filter(e -> e.name.startsWith("D") && e.name.endsWith("a"))
                .collect(toList()));

        // Challenge 2
        System.out.println("Challenge 2: " + employees.stream()
                .collect(groupingBy(Employee_8::getDepartment))
                .entrySet().stream()
                .filter(e -> e.getValue().size() > 1)
                .map(Map.Entry::getKey)
                .collect(toList()));

        // Challenge 3
        System.out.println("Challenge 3: " + employees.stream()
                .map(Employee_8::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().orElse(-1.0));
    }
}
/*Q1: [Ravi, Priya, Arun, Kavya, Divya]
Q2: [102 - Priya - IT - 60000.0, 104 - Kavya - IT - 70000.0]
Q3: 2
Q4: [104 - Kavya - IT - 70000.0, 102 - Priya - IT - 60000.0, 103 - Arun - HR - 55000.0, 101 - Ravi - HR - 50000.0, 105 - Divya - Sales - 45000.0]
Q5: Optional[104 - Kavya - IT - 70000.0]
Q6: 56000.0
Q7: [Ravi, Priya, Arun, Kavya, Divya]
Q8: {Sales=[105 - Divya - Sales - 45000.0], HR=[101 - Ravi - HR - 50000.0, 103 - Arun - HR - 55000.0], IT=[102 - Priya - IT - 60000.0, 104 - Kavya - IT - 70000.0]}
Q9: {Sales=45000.0, HR=105000.0, IT=130000.0}
Q10: [Priya, Kavya]
Q11: false
Q12: Ravi, Priya, Arun, Kavya, Divya
Q13: [104 - Kavya - IT - 70000.0, 102 - Priya - IT - 60000.0]
Q14: [103 - Arun - HR - 55000.0, 104 - Kavya - IT - 70000.0, 105 - Divya - Sales - 45000.0]
Q15: [Ravi, Priya, Arun]
Q16: Optional[101 - Ravi - HR - 50000.0]
Q17: {false=[101 - Ravi - HR - 50000.0, 103 - Arun - HR - 55000.0, 105 - Divya - Sales - 45000.0], true=[102 - Priya - IT - 60000.0, 104 - Kavya - IT - 70000.0]}
Q18: {Sales=45000.0, HR=52500.0, IT=65000.0}
Q19: [103 - Arun - HR - 55000.0, 105 - Divya - Sales - 45000.0, 104 - Kavya - IT - 70000.0, 102 - Priya - IT - 60000.0, 101 - Ravi - HR - 50000.0]
Q20: {101=Ravi, 102=Priya, 103=Arun, 104=Kavya, 105=Divya}
Challenge 1: [105 - Divya - Sales - 45000.0]
Challenge 2: [HR, IT]
Challenge 3: 60000.0

*/