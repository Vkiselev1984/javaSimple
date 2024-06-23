package ModelViewController.Service;

import ModelViewController.Model.Student;
import ModelViewController.Model.Teacher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataService {
    private final Map<String, Student> studentsMap = new HashMap<>();
    private final Map<String, Teacher> teachersMap = new HashMap<>();
    private int studentIdCounter = 1;
    private int teacherIdCounter = 1;

    public void createStudent(String fullName, int birthYear) {
        Student newStudent = new Student(fullName, birthYear);
        studentsMap.put("student" + studentIdCounter, newStudent);
        studentIdCounter++;
    }

    public void createTeacher(String fullName, int birthYear, String subject) {
        Teacher newTeacher = new Teacher(fullName, birthYear, subject);
        teachersMap.put("teacher" + teacherIdCounter, newTeacher);
        teacherIdCounter++;
    }

    public Student readStudent(String studentId) {
        return studentsMap.get(studentId);
    }

    public Teacher readTeacher(String teacherId) {
        return teachersMap.get(teacherId);
    }

    public String generateId(String type) {
        if (type.equals("student")) {
            return "student" + studentIdCounter;
        } else if (type.equals("teacher")) {
            return "teacher" + teacherIdCounter;
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(studentsMap.values());
    }

    public List<Teacher> getAllTeachers() {
        return new ArrayList<>(teachersMap.values());
    }
}