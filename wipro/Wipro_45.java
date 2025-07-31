package wipro;

import java.util.*;
import java.util.stream.Collectors;

class Student {
    int id;
    String name;
    String department;

    public Student(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public String toString() {
        return name;
    }
}

public class Wipro_45 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student(1, "mani", "CSE"),
            new Student(2, "Anjali", "ECE"),
            new Student(3, "Bhavya", "CSE"),
            new Student(4, "Kiran", "EEE"),
            new Student(5, "Priya", "ECE"),
            new Student(6, "Arjun", "CSE")
        );

        // Grouping students by department using Java 8 Stream API
        Map<String, List<Student>> groupedByDept = students.stream()
            .collect(Collectors.groupingBy(s -> s.department));

        // Print each department and its students
        for (Map.Entry<String, List<Student>> entry : groupedByDept.entrySet()) {
            System.out.println("Department: " + entry.getKey());
            System.out.println("Students: " + entry.getValue());
            System.out.println();
        }
    }
}
/*Department: EEE
Students: [Kiran]

Department: CSE
Students: [mani, Bhavya, Arjun]

Department: ECE
Students: [Anjali, Priya]

*/