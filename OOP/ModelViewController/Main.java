import ModelViewController.Controller.Controller;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();

        controller.createStudent("Ivan", 1999);
        controller.createStudent("Petr", 1999);
        controller.createTeacher("Vladimir", 1984, "OOP");

        controller.displayStudents();
        controller.displayTeachers();

        controller.createStudyGroupWithIds("teacher1", Arrays.asList("student1", "student2"));
    }
}