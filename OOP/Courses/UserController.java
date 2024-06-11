import java.util.List;
import java.util.Comparator;

public interface UserController<T extends User> {
    void create(T user);
    void removeUserByName(List<T> users, String name);
    void sortUsers(List<T> users, Comparator<T> comparator);
}