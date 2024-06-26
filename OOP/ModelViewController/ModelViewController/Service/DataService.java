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

    // Service class responsible for managing data storage and retrieval
    // This class follows the Single Responsibility Principle by focusing on data management operations.

    public void createStudent(String fullName, int birthYear) {
        Student newStudent = new Student(fullName, birthYear);
        studentsMap.put("student" + studentIdCounter, newStudent);
        studentIdCounter++;
    }

    // Method createStudent creates a new student object and stores it in the studentsMap with a generated key. 
    // It increments the studentIdCounter to ensure unique student IDs.
    // This part of the code is responsible for creating and managing student data in the system.

    public void createTeacher(String fullName, int birthYear, String subject) {
        Teacher newTeacher = new Teacher(fullName, birthYear, subject);
        teachersMap.put("teacher" + teacherIdCounter, newTeacher);
        teacherIdCounter++;
    }

    // Similar to the createStudent method, this method in the DataService class creates a new teacher object and stores it in the teachersMap with a generated key. 
    // It also increments the teacherIdCounter to ensure unique teacher IDs.
    // This part of the code is responsible for creating and managing teacher data in the system.

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

    // GetAllStudents returns a list of all students by converting the values of the studentsMap (which stores students) to a new ArrayList. 
    // This method provides a way to retrieve all student data from the system.

    public List<Teacher> getAllTeachers() {
        return new ArrayList<>(teachersMap.values());
    }

    // GetAllTeachers returns a list of all teachers by converting the values of the teachersMap (which stores teachers) to a new ArrayList. 
    // This method provides a way to retrieve all teacher data from the system.
}