package ModelViewController.Controller;

import ModelViewController.Model.Student;
import ModelViewController.Model.StudyGroup;
import ModelViewController.Model.Teacher;
import ModelViewController.Service.DataService;
import ModelViewController.View.StudentView;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final DataService dataService = new DataService();
    private final StudentView studentView = new StudentView();

    public Student createStudent(String fullName, int birthYear) {
        Student newStudent = new Student(fullName, birthYear);
        dataService.createStudent(fullName, birthYear);
        return newStudent;
    }

    public Teacher createTeacher(String fullName, int birthYear, String subject) {
        Teacher newTeacher = new Teacher(fullName, birthYear, subject);
        dataService.createTeacher(fullName, birthYear, subject);
        return newTeacher;
    }

    public StudyGroup createStudyGroupWithIds(String teacherId, List<String> studentIds) {
        Teacher teacher = dataService.readTeacher(teacherId);
        List<Student> students = new ArrayList<>();
        for (String studentId : studentIds) {
            Student student = dataService.readStudent(studentId);
            if (student != null) {
                students.add(student);
            }
        }
        return new StudyGroup(teacher, students);
    }

    public void displayStudents() {
        List<Student> students = dataService.getAllStudents();
        studentView.printStudents(students);
    }

    public void displayTeachers() {
        List<Teacher> teachers = dataService.getAllTeachers();
        studentView.printTeachers(teachers);
    }
}