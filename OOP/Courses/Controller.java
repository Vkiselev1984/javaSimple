import java.util.List;

public class Controller {
    private StreamService streamService;

    public Controller(StreamService streamService) {
        this.streamService = streamService;
    }

    public void processStudentGroups(List<StudentGroup> studentGroups) {
        streamService.sortStudentGroups(studentGroups);
    }
}