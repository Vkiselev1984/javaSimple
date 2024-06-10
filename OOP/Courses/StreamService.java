import java.util.Collections;
import java.util.List;

public class StreamService {
    public void sortStudentGroups(List<StudentGroup> studentGroups) {
        Collections.sort(studentGroups, new StreamComparator());
    }
}