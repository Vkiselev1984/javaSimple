package ModelViewController.Model;

import java.util.List;

public class StudyGroup {
    private final Teacher teacher;
    private final List<Student> students;

    // Model class representing a study group with a teacher and a list of students
    // This class follows the Single Responsibility Principle by focusing on study group representation.

    public StudyGroup(Teacher teacher, List<Student> students) {
        this.teacher = teacher;
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudents() {
        return students;
    }
}