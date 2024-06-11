import java.util.Comparator;

public class UserComparator<T extends User> implements Comparator<T> {

    @Override
    public int compare(T u1, T u2) {
        String fullNameId1 = u1.getFullName() + " " + getStudentId(u1);
        String fullNameId2 = u2.getFullName() + " " + getStudentId(u2);
        return fullNameId1.compareTo(fullNameId2);
    }

    private int getStudentId(T user) {
        if (user instanceof Student) {
            return ((Student) user).getStudentId();
        } else {
            return -1;
        }
    }
}