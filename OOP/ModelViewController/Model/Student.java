package ModelViewController.Model;

public class Student extends User {
    
    private String studentId;

    public Student(String fullName, int birthYear, String studentId) {
        super(fullName, birthYear);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Student [studentId=" + studentId + super.toString() + "]";
    }

}