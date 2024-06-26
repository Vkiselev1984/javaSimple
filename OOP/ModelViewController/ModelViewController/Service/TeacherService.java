package ModelViewController.Service;

import ModelViewController.Model.Teacher;
import java.util.ArrayList;
import java.util.List;

public class TeacherService {
    private final List<Teacher> teachers = new ArrayList<>();

     // Service class responsible for creating, reading, and managing teachers
    // This class follows the Single Responsibility Principle by focusing on teacher-related operations.

    public Teacher createTeacher(String fullName, int birthYear, String subject) {
        Teacher teacher = new Teacher(fullName, birthYear, subject);
        teachers.add(teacher);
        return teacher;
    }

    // CreateTeacher method creates a new teacher object, adds it to the list of teachers, and returns the created teacher. 
    // This method also follows SRP by focusing on teacher creation and management.

    public Teacher readTeacher(String teacherId) {
        for (Teacher teacher : teachers) {
            if (teacher.getId().equals(teacherId)) {
                return teacher;
            }
        }
        return null;
    }

    public List<Teacher> getAllTeachers() {
        return teachers;
    }
}