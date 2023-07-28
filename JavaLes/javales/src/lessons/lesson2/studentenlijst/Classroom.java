package javales.src.lessons.lesson2.studentenlijst;

import java.util.ArrayList;
import java.util.List;

public class Classroom {

    private String name;

    private Mentor mentor;

    private List<Student> students = new ArrayList<>();

    /**
     * @return List<Student>
     */
    public List<Student> getStudents() {
        return this.students;
    }

    /**
     * @param students
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /**
     * @return Mentor
     */
    public Mentor getMentor() {
        return this.mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Classroom(String name, Mentor mentor) {

        this.name = name;
        this.mentor = mentor;
    }

    public Classroom(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        // look up student
        Student found = this.students.stream().filter(s -> student.getName().equals(s.getName())).findFirst()
                .orElse(null);
        // if student does not exist add student, prevent redudant records
        if (found == null) {
            this.students.add(student);
        }
    }

}
