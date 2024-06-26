package ModelViewController.Service;

import ModelViewController.Model.Student;
import ModelViewController.Model.StudyGroup;
import ModelViewController.Model.Teacher;
import java.util.List;

public class StudyGroupService {

    // Service class responsible for creating study groups
    // This class follows the Single Responsibility Principle by focusing on study group creation.

    public StudyGroup createStudyGroup(Teacher teacher, List<Student> students) {
        StudyGroup studyGroup = new StudyGroup(teacher, students);
        return studyGroup;
    }

    // The createStudyGroup method creates a new study group object with a given teacher and list of students. 
    // It encapsulates the logic of creating a study group, adhering to the SRP by focusing on study group creation only.

}