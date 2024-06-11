import java.util.Iterator;
import java.util.List;

public class GroupIterator implements Iterator<Student> {
    private List<Student> students;
    private int position;

    public GroupIterator(List<Student> students) {
        this.students = students;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < students.size();
    }

    @Override
    public Student next() {
        if (hasNext()) {
            Student student = students.get(position);
            position++;
            return student;
        }
        return null;
    }

    @Override
    public void remove() {
        if (position > 0) {
            students.remove(position - 1);
            position--;
        }
    }
}