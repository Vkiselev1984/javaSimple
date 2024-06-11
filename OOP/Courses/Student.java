public class Student extends User implements Comparable<Student> {
    private Group<Student> group;
    private int studentId;

    public Student(String name, String surname, Group<Student> group) {
        super(name, surname);
        this.group = group;
    }

    public Student(String name, String surname) {
        super(name, surname);
    }

    public int getStudentId() {
        return studentId;
    }

    @Override
    public int compareTo(Student otherStudent) {
        return Integer.compare(this.studentId, otherStudent.getStudentId());
    }

    public String getFullName() {
        if (getSurname() != null && !getSurname().isEmpty()) {
            return getName() + " " + getSurname();
        } else {
            return getName();
        }
    }

    public void removeStudent(Student student) {
        if (student != null && group != null) {
            group.removeStudent(student);
        }
    }
}