import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(4, "aab", "aab", "aab");
        Student student2 = new Student(3, "aaa", "aaa", "aaa");
        Student student3 = new Student(2, "Aaa", "Aaa", "Aaa");
        Student student4 = new Student(1, "bbb", "bbb", "bbb");

        List<Student> studentList1 = new ArrayList<>();
        List<Student> studentList2 = new ArrayList<>();

        StudentGroup studentGroup1 = new StudentGroup(studentList1);
        StudentGroup studentGroup2 = new StudentGroup(studentList2);

        studentGroup1.addStudent(student1);
        studentGroup1.addStudent(student2);

        studentGroup2.addStudent(student3);
        studentGroup2.addStudent(student4);

        StreamService streamService = new StreamService();
        Controller controller = new Controller(streamService);

        List<StudentGroup> studentGroups = new ArrayList<>();
        studentGroups.add(studentGroup1);
        studentGroups.add(studentGroup2);

        controller.processStudentGroups(studentGroups);

        for (StudentGroup group : studentGroups) {
            System.out.println("Group:");
            for (Student student : group) {
                System.out.println(student);
            }
        }
    }
}