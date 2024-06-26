package ModelViewController.Service;

import ModelViewController.Model.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private final List<Student> students = new ArrayList<>();

     // Service class responsible for creating, reading, and managing students
    // This class follows the Single Responsibility Principle by focusing on student-related operations.

    public Student createStudent(String fullName, int birthYear) {
        Student student = new Student(fullName, birthYear);
        students.add(student);
        return student;
    }

    // CreateStudent method creates a new student object, adds it to the list of students, and returns the created student. 
    // This method follows SRP by handling student creation and management operations.

    public Student readStudent(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return students;
    }
}