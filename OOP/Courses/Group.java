import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Group<T extends Student> implements Iterable<T> {
    private String groupName;
    private List<T> students;

    public Group(String groupName) {
        this.groupName = groupName;
        this.students = new ArrayList<>();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void addStudent(T student) {
        students.add(student);
    }

    public void removeStudentByObject(T student) {
        students.remove(student);
    }

        public List<T> getStudents() {
        return students;
    }


    @Override
    public Iterator<T> iterator() {
        return students.iterator();
    }

    public void removeStudent(Student student) {
        Iterator<T> iterator = students.iterator();
        while (iterator.hasNext()) {
            T currentStudent = iterator.next();
            if (currentStudent.equals(student)) {
                iterator.remove();
                break;
            }
        }
    }
}