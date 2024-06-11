import java.util.List;

public class StudentView implements UserView<Student> {

    @Override
    public void displayUserInfo(Student student) {
        System.out.println("Student: " + student.getName() + " " + student.getSurname());
    }

    @Override
    public void displayUserDetails(Student student) {
        System.out.println("Student details: " + student.getName() + " " + student.getSurname() + ", ID: " + student.getStudentId());
    }

    @Override
    public void sendOnConsole(List<Student> students) {
        System.out.println("List of students:");
        for (Student student : students) {
            System.out.println(student.getName() + " " + student.getSurname());
        }
    }
}