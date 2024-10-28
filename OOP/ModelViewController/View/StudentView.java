package View;

import java.util.List;

import Model.Student;
import Model.Teacher;

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