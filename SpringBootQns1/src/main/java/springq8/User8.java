package springq8;

public class User8 {
    private String firstName;
    private String lastName;
    private int age;

    // Constructors
    public User8() {
    }

    public User8(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    // toString
    @Override
    public String toString() {
        return "User8 [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
    }
}
