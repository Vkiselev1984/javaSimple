package ModelViewController.Controller;

import ModelViewController.Model.Student;
import ModelViewController.Model.StudyGroup;
import ModelViewController.Model.Teacher;
import ModelViewController.Service.StudentService;
import ModelViewController.Service.StudyGroupService;
import ModelViewController.Service.TeacherService;
import ModelViewController.View.StudentView;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final StudentService studentService = new StudentService();
    private final TeacherService teacherService = new TeacherService();
    private final StudyGroupService studyGroupService = new StudyGroupService();
    private final StudentView studentView = new StudentView();

    // Controller class responsible for handling user interactions and delegating tasks to service classes
    // This class follows the Single Responsibility Principle by focusing on user interactions and delegating tasks.
    // Methods for creating students, teachers, and study groups, as well as displaying them

    public Student createStudent(String fullName, int birthYear) {
        return studentService.createStudent(fullName, birthYear);
    }

  

    public Teacher createTeacher(String fullName, int birthYear, String subject) {
        return teacherService.createTeacher(fullName, birthYear, subject);
    }

    public StudyGroup createStudyGroupWithIds(String teacherId, List<String> studentIds) {
        Teacher teacher = teacherService.readTeacher(teacherId);
        List<Student> students = new ArrayList<>();
        for (String studentId : studentIds) {
            Student student = studentService.readStudent(studentId);
            if (student != null) {
                students.add(student);
            }
        }
        return studyGroupService.createStudyGroup(teacher, students);
    }

    // СreateStudyGroupWithIds creates a study group by first retrieving the teacher object using the provided teacher ID. It then iterates over the list of student IDs, retrieves each student object using the student ID, and adds valid students to the list. Finally, it creates a study group using the retrieved teacher and student objects. 
    // This method coordinates the creation of a study group based on provided teacher and student IDs.

    public void displayStudents() {
        List<Student> students = studentService.getAllStudents();
        studentView.printStudents(students);
    }

    // DisplayStudents retrieves all students using the StudentService, then passes the list of students to the StudentView to print them. 
    // This method separates the logic of fetching student data and displaying it, adhering to the SRP.

    public void displayTeachers() {
        List<Teacher> teachers = teacherService.getAllTeachers();
        studentView.printTeachers(teachers);
    }

    // DisplayTeachers retrieves all teachers using the TeacherService and then passes the list of teachers to the StudentView to print them. 
    // This method separates the responsibility of fetching teacher data and displaying it, following the SRP.
}