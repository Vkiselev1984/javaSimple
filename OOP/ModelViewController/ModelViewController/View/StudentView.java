package ModelViewController.View;

import ModelViewController.Model.Student;
import ModelViewController.Model.Teacher;
import java.util.List;

public class StudentView {

    // View class responsible for displaying student and teacher information
    // This class follows the Single Responsibility Principle by focusing on displaying data.

    public void printStudents(List<Student> students) {
        System.out.println("List of Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void printTeachers(List<Teacher> teachers) {
        System.out.println("List of Teachers:");
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }
}