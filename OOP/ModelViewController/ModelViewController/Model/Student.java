package ModelViewController.Model;

public class Student extends User {
    
    private static int nextId = 1;
    private String studentId;

    // Model class representing a student with a unique student ID
    // This class follows the Single Responsibility Principle by focusing on student representation.

    public Student(String fullName, int birthYear) {
        super(fullName, birthYear);
        this.studentId = "S" + nextId++;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getId() {
        return getStudentId();
    }

    @Override
    public String toString() {
        return studentId + super.toString();
    }
}