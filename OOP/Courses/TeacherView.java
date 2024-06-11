import java.util.List;

public class TeacherView {
    
    public void printTeacherDetails(Teacher teacher) {
        if (teacher != null) {
            System.out.println("Teacher Details:");
            System.out.println("Name: " + teacher.getName());
            System.out.println("Subject: " + teacher.getSubject());
        } else {
            System.out.println("Teacher details not available.");
        }
    }

    public void printTeachersList(List<Teacher> teachers) {
        System.out.println("List of Teachers:");
        for (Teacher teacher : teachers) {
            System.out.println("Name: " + teacher.getName() + ", Subject: " + teacher.getSubject());
        }
    }

}