package wipro;

public class Wipro_34 {

    public static void main(String[] args) {
        Employee e1 = new Employee("81-F-112", "Anil", 1960);
        Employee e2 = new Employee("79-S-254", "Bharath", 1959);

        System.out.println("--- Employee 1 ---");
        e1.displayDetails();

        System.out.println("--- Employee 2 ---");
        e2.displayDetails();
    }
}

class Employee {
    private String employeeId;
    private String name;
    private int yearOfBirth;

    public Employee(String employeeId, String name, int yearOfBirth) {
        this.employeeId = employeeId;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public int getJoiningYear() {
        String[] parts = employeeId.split("-");
        return Integer.parseInt("19" + parts[0]);
    }

    public String getDesignation() {
        char code = employeeId.split("-")[1].charAt(0);
        if (code == 'F') return "Faculty";
        else if (code == 'S') return "Staff";
        else return "Unknown";
    }

    public int getSerialNumber() {
        return Integer.parseInt(employeeId.split("-")[2]);
    }

    public void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Year of Birth: " + yearOfBirth);
        System.out.println("Joining Year: " + getJoiningYear());
        System.out.println("Designation: " + getDesignation());
        System.out.println("Serial Number: " + getSerialNumber());
        System.out.println();
    }
}

/*--- Employee 1 ---
Employee Name: Anil
Employee ID: 81-F-112
Year of Birth: 1960
Joining Year: 1981
Designation: Faculty
Serial Number: 112

--- Employee 2 ---
Employee Name: Bharath
Employee ID: 79-S-254
Year of Birth: 1959
Joining Year: 1979
Designation: Staff
Serial Number: 254

*/
