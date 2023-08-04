package javales.src.lessons.lesson2.studentenlijst;

import java.util.ArrayList;
import java.util.List;

public class Classroom {

    private String name;

    private IMentor mentor;

    private List<IStudent> students = new ArrayList<>();

    /**
     * @return List<Student>
     */
    public List<IStudent> getStudents() {
        return this.students;
    }

    /**
     * @param students
     */
    public void setStudents(List<IStudent> students) {
        this.students = students;
    }

    /**
     * @return Mentor
     */
    public IMentor getMentor() {
        return this.mentor;
    }

    public void setMentor(IMentor mentor) {
        this.mentor = mentor;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Classroom(String name, IMentor mentor) {
        this.setName(name);
        this.setMentor(mentor);
    }

    public Classroom(String name) {
        this.name = name;
    }

    public void addStudent(IStudent student) {
        // look up student
        IStudent found = this.students.stream().filter(s -> student.getName().equals(s.getName())).findFirst()
                .orElse(null);
        // if student does not exist add student, prevent redudant records
        if (found == null) {
            this.students.add(student);
        }
    }

}
