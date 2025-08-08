package mockito;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class StudentServiceTest {

    @Test
    public void testGetStudentById() {
        // Create a mock repository
        StudentRepository mockRepo = mock(StudentRepository.class);

        // Stub the findById method
        when(mockRepo.findById(1)).thenReturn(new Student(1, "John"));

        // Use the mock in the service
        StudentService service = new StudentService(mockRepo);

        // Assert the result
        assertEquals("John", service.getStudentById(1));

        // Verify the method was called
        verify(mockRepo).findById(1);
    }
}
