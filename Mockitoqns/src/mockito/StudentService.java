package mockito;

public class StudentService {
    private StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public String getStudentById(int id) {
        Student s = repo.findById(id);
        return s.getName();
    }
}
