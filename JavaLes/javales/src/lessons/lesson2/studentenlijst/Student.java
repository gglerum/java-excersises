package javales.src.lessons.lesson2.studentenlijst;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    private String studentNumber;

    private List<Subject> grades = new ArrayList<>();

    public Student(String name, int age) {
        super(name, age);
    }

    /**
     * @param studentNumber
     */
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    /**
     * @return the studentNumber
     */
    public String getStudentNumber() {
        return this.studentNumber;
    }

    /**
     * @return the grades
     */
    public List<Subject> getGrades() {
        return grades;
    }

    /**
     * @param newSubject
     * @param grade
     */
    public void addGrade(String newSubject, double grade) {
        // find the subject in the grades list by subject name
        Subject subject = this.grades.stream().filter(s -> newSubject.equals(s.getName())).findFirst().orElse(null);
        // if subject has been found change the grade, else add the subject to the list
        // with grade
        if (subject != null) {
            subject.setGrade(grade);
        } else {
            this.grades.add(new Subject(newSubject, grade));
        }
    }

}
