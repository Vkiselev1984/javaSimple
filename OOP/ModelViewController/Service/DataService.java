package Service;

import java.util.ArrayList;
import java.util.List;

import Model.Student;
import Model.Teacher;

public class DataService {
    private final List<Student> students = new ArrayList<>();
    private final List<Teacher> teachers = new ArrayList<>();

    public Student createStudent(String fullName, int birthYear) {
        Student newStudent = new Student(fullName, birthYear, generateId());
        students.add(newStudent);
        return newStudent;
    }

    public Teacher createTeacher(String fullName, int birthYear) {
        Teacher newTeacher = new Teacher(fullName, birthYear, generateId());
        teachers.add(newTeacher);
        return newTeacher;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public List<Teacher> getAllTeachers() {
        return teachers;
    }

    public Teacher readTeacher(String teacherId) {
        for (Teacher teacher : teachers) {
            if (teacher.getId().equals(teacherId)) {
                return teacher;
            }
        }
        return null;
    }

    public Student readStudent(String studentId) {
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    private String generateId() {
        return "TID123";
    }
}