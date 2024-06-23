import ModelViewController.Model.Student;
import ModelViewController.Model.StudyGroup;
import ModelViewController.Model.Teacher;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        Teacher teacher = new Teacher("Vladimir", 1980, "Math");
        List<Student> students = new ArrayList<>();
        students.add(new Student("Evgeny", 1991));
        students.add(new Student("Nikolay", 1990));

        StudyGroup studyGroup = new StudyGroup(teacher, students);

        System.out.println("Teacher: " + studyGroup.getTeacher().getFullName());
        System.out.println("Students in the group:");
        for (Student student : studyGroup.getStudents()) {
            System.out.println("Student ID: " + student.getStudentId() + ", Name: " + student.getFullName() + ", Birth Year: " + student.getBirthYear());
        }
    }
}