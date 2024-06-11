import java.util.List;

public interface UserView<T extends User> {
    void displayUserInfo(T user);
    void displayUserDetails(T user);
    void sendOnConsole(List<T> users);
}