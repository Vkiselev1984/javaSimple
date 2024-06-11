import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TeacherService<T extends Teacher> implements Iterable<T> {
    private List<T> teachers;

    public TeacherService() {
        this.teachers = new ArrayList<>();
    }


    public void addTeacher(T teacher) {
        teachers.add(teacher);
    }

    public void removeTeacherByObject(T teacher) {
        teachers.remove(teacher);
    }

    public List<T> getTeachers() {
        return teachers;
    }

    @Override
    public Iterator<T> iterator() {
        return teachers.iterator();
    }

    public void removeTeacher(Teacher teacher) {
        Iterator<T> iterator = teachers.iterator();
        while (iterator.hasNext()) {
            T currentTeacher = iterator.next();
            if (currentTeacher.equals(teacher)) {
                iterator.remove();
                break;
            }
        }
    }
}