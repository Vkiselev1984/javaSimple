package ModelViewController.Service;

import ModelViewController.Model.Student;
import ModelViewController.Model.StudyGroup;
import ModelViewController.Model.Teacher;
import java.util.List;

public class StudyGroupService {
    public StudyGroup createStudyGroup(Teacher teacher, List<Student> students) {
        return new StudyGroup(teacher, students);
    }
}