package ModelViewController.Model;

public class Teacher extends User {

    // Model class representing a teacher with a unique teacher ID
    // This class follows the Single Responsibility Principle by focusing on teacher representation.
    
    private String teacherId;

    // Teacher class extending User with additional teacherId
    public Teacher(String fullName, int birthYear, String teacherId) {
        super(fullName, birthYear);
        this.teacherId = teacherId;
    }

    // Getter and setter for teacherId
    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    // Get the ID of the teacher
    public String getId() {
        return getTeacherId();
    }

    // Override toString method to display teacher information
    @Override
    public String toString() {
        return teacherId + super.toString();
    }
}