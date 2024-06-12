package ModelViewController.Service;

import java.util.ArrayList;
import java.util.List;

import ModelViewController.Model.Student;
import ModelViewController.Model.Teacher;

public class DataService {
    private List<Student> students;
    private List<Teacher> teachers;

    public DataService() {
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
    }

    public Student createStudent(String fullName, int birthYear) {
        String studentId = generateStudentId();
        Student student = new Student(fullName, birthYear, studentId);
        students.add(student);
        return student;
    }

    public Teacher createTeacher(String fullName, int birthYear) {
        String teacherId = generateTeacherId();
        Teacher teacher = new Teacher(fullName, birthYear, teacherId);
        teachers.add(teacher);
        return teacher;
    }

    public Student readStudent(String id) {
        return students.stream()
                .filter(student -> student.getStudentId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Teacher readTeacher(String id) {
        return teachers.stream()
                .filter(teacher -> teacher.getTeacherId().equals(id))
                .findFirst()
                .orElse(null);
    }

    private String generateStudentId() {
        return String.valueOf(students.size() + 1);
    }

    private String generateTeacherId() {
        return String.valueOf(teachers.size() + 1);
    }
}
