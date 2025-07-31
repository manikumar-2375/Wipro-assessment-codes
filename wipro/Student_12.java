package wipro;

public class Student_12 {
    private static int rollCounter = 1;

    private int rollNo;
    private String studName;
    private int marksInEng;
    private int marksInMaths;
    private int marksInScience;

    public Student_12(String studName, int eng, int maths, int science) {
        this.rollNo = rollCounter++;
        this.studName = studName;
        this.marksInEng = eng;
        this.marksInMaths = maths;
        this.marksInScience = science;
    }

    public int getRollNo() { return rollNo; }
    public String getStudName() { return studName; }
    public int getMarksInEng() { return marksInEng; }
    public int getMarksInMaths() { return marksInMaths; }
    public int getMarksInScience() { return marksInScience; }

    public int getTotalMarks() {
        return marksInEng + marksInMaths + marksInScience;
    }

    public double getPercentage() {
        return getTotalMarks() / 3.0;
    }
}
import java.util.*;

public class Standard {
    List<Student> students = new ArrayList<>();

    public Standard() {
        students.add(new Student("Anil", 75, 88, 92));
        students.add(new Student("Bharath", 60, 95, 85));
        students.add(new Student("Charan", 80, 78, 88));
        students.add(new Student("Deepika", 95, 90, 99));
        students.add(new Student("Esha", 70, 65, 74));
        students.add(new Student("Farhan", 50, 60, 55));
        students.add(new Student("Gauri", 85, 92, 89));
        students.add(new Student("Harsha", 67, 72, 60));
    }

    // 1. Display all students in ascending order of roll number
    public void displayStudentsByRollNo() {
        students.stream()
                .sorted(Comparator.comparingInt(Student::getRollNo))
                .forEach(s -> System.out.println(s.getRollNo() + " - " + s.getStudName()));
    }

    // 2. Display student with highest percentage
    public void displayTopper() {
        Student topper = students.stream()
                .max(Comparator.comparingDouble(Student::getPercentage))
                .orElse(null);
        if (topper != null)
            System.out.println("Topper: " + topper.getRollNo() + " - " + topper.getStudName());
    }

    // 3. Display student with highest marks in mathematics
    public void displayTopMathsStudent() {
        Student topMath = students.stream()
                .max(Comparator.comparingInt(Student::getMarksInMaths))
                .orElse(null);
        if (topMath != null)
            System.out.println("Top Maths: " + topMath.getRollNo() + " - " + topMath.getStudName());
    }

    // 4. Display students by total of maths + science
    public void displayByMathsScienceTotal() {
        students.stream()
                .sorted(Comparator.comparingInt(s -> s.getMarksInMaths() + s.getMarksInScience()))
                .forEach(s -> System.out.println(s.getRollNo() + " - " + s.getStudName()));
    }

    // 5. Display roll no, name, total, percentage, and rank by descending marks
    public void displayRankList() {
        List<Student> sorted = new ArrayList<>(students);
        sorted.sort((s1, s2) -> Integer.compare(s2.getTotalMarks(), s1.getTotalMarks()));

        int rank = 1;
        for (Student s : sorted) {
            System.out.printf("Rank %d: RollNo: %d, Name: %s, Total: %d, Percentage: %.2f%%\n",
                    rank++, s.getRollNo(), s.getStudName(), s.getTotalMarks(), s.getPercentage());
        }
    }




	public static void main(String[] args) {
		
		 Standard std = new Standard();
	        System.out.println("1. Students by Roll No:");
	        std.displayStudentsByRollNo();

	        System.out.println("\n2. Topper:");
	        std.displayTopper();

	        System.out.println("\n3. Top Maths Scorer:");
	        std.displayTopMathsStudent();

	        System.out.println("\n4. By Maths + Science Total:");
	        std.displayByMathsScienceTotal();

	        System.out.println("\n5. Rank List:");
	        std.displayRankList();
		// TODO Auto-generated method stub

	}

}
