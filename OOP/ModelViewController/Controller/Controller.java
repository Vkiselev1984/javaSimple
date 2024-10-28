package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Student;
import Model.StudyGroup;
import Model.Teacher;
import Service.DataService;
import View.StudentView;

public class Controller {
    private final DataService dataService = new DataService();
    private final StudentView studentView = new StudentView();

    public Student createStudent(String fullName, int birthYear) {
        Student newStudent = dataService.createStudent(fullName, birthYear);
        List<Student> allStudents = dataService.getAllStudents();
        studentView.printStudents(allStudents);
        return newStudent;
    }

    public Teacher createTeacher(String fullName, int birthYear) {
        Teacher newTeacher = dataService.createTeacher(fullName, birthYear);
        List<Teacher> allTeachers = dataService.getAllTeachers();
        studentView.printTeachers(allTeachers);
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
}