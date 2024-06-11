import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class StudentController {
    
    public StudentController() {
    }

    public void sendOnConsole(String message) {
        System.out.println(message);
    }

    public void create(Student student) {
        if (student != null) {
            sendOnConsole("Student created: " + student.getName() + " " + student.getSurname());
        } else {
            sendOnConsole("Error: Cannot create student. Invalid student object.");
        }
    }

    public void removeUserByName(List<Student> students, String name) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getName().equals(name)) {
                iterator.remove();
                sendOnConsole("Student removed: " + student.getName() + " " + student.getSurname());
            }
        }
    }
    
    public void sortUsers(List<Student> students, Comparator<Student> comparator) {
        Collections.sort(students, comparator);
        sendOnConsole("Students sorted based on the provided comparator.");
    }
}