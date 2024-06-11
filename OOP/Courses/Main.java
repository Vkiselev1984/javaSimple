public class Main {
    public static void main(String[] args) {
        Group<Student> group = new Group<>("Group 1");
        Student student1 = new Student("Alice", "Smith", group);
        Student student2 = new Student("Bob", "Johnson", group);
        Student student3 = new Student("Tim", "Ford", group);

        GroupService groupService = new GroupService();
        groupService.addStudentToGroup(student1, group);
        groupService.addStudentToGroup(student2, group);
        groupService.addStudentToGroup(student3, group);

        StudentView studentView = new StudentView();
        System.out.println("Students in the group:");
        studentView.sendOnConsole(groupService.getStudentsInGroup(group));

        groupService.removeStudentFromGroupByName("Alice", group);
        System.out.println("\nStudents in the group after removal:");
        studentView.sendOnConsole(groupService.getStudentsInGroup(group));

        Teacher teacher1 = new Teacher("John", "Math");
        Teacher teacher2 = new Teacher("Jane", "English");

        TeacherController teacherController = new TeacherController();
        teacherController.createTeacher(teacher1.getName(), teacher1.getSubject());
        teacherController.createTeacher(teacher2.getName(), teacher2.getSubject());

        TeacherView teacherView = new TeacherView();
        System.out.println("\nTeachers in the system:");
        teacherView.printTeachersList(teacherController.getTeachers());
    }
}