import java.util.List;

public class GroupService {
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void addStudentToGroup(Student student, Group<Student> group) {
        group.addStudent(student);
    }

    public void removeStudentFromGroup(Student student, Group<Student> group) {
        group.removeStudent(student);
    }

    public List<Student> getStudentsInGroup(Group<Student> group) {
        return group.getStudents();
    }

    public void removeStudentFromGroupByName(String studentName, Group<Student> group) {
        List<Student> students = group.getStudents();
        for (Student student : students) {
            if (student.getName().equals(studentName)) {
                group.removeStudent(student);
                break;
            }
        }
    }
}