import java.util.ArrayList;
import java.util.List;

public class TeacherController {
    private List<Teacher> teachers;

    public TeacherController() {
        this.teachers = new ArrayList<>();
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void createTeacher(String name, String subject) {
        Teacher newTeacher = new Teacher(name, subject);
        teachers.add(newTeacher);
        System.out.println("Teacher created: " + newTeacher.getName());
    }

    public void editTeacher(Teacher teacher, String newName, String newSubject) {
        teacher.setName(newName);
        teacher.setSubject(newSubject);
        System.out.println("Teacher edited: " + teacher.getName());
    }

    public void displayTeachers() {
        System.out.println("List of Teachers:");
        for (Teacher teacher : teachers) {
            System.out.println("Name: " + teacher.getName() + ", Subject: " + teacher.getSubject());
        }
    }
}