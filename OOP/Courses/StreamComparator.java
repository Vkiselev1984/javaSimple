import java.util.Comparator;

public class StreamComparator implements Comparator<StudentGroup> {
    @Override
    public int compare(StudentGroup group1, StudentGroup group2) {
        int id1 = group1.iterator().next().getStudentId();
        int id2 = group2.iterator().next().getStudentId();
        return Integer.compare(id1, id2);
    }
}