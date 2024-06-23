package ModelViewController.View;

import ModelViewController.Model.Student;
import ModelViewController.Model.Teacher;
import java.util.List;

public class StudentView {
    
    public void printStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    public void printTeachers(List<Teacher> teachers) {
        for (Teacher teacher : teachers) {
            System.out.println(teacher.toString());
        }
    }
}