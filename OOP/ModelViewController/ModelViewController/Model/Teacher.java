package ModelViewController.Model;

public class Teacher extends User {
    
    private String teacherId;

    public Teacher(String fullName, int birthYear, String teacherId) {
        super(fullName, birthYear);
        this.teacherId = teacherId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getId() {
        return getTeacherId();
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId + super.toString() + 
                '}';
    }
}