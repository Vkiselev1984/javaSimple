
import controller.Menu;
import model.DatabaseConnection;
import view.ConsoleView;

public class Main {

    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        DatabaseConnection dbConnection = new DatabaseConnection();
        Menu menu = new Menu(view, dbConnection);
        view.start(menu);
    }
}
