package javales.src.lessons.lesson2.studentenlijst;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person implements IStudent {

    private String studentNumber;

    private List<ISubject> grades = new ArrayList<>();

    private double average = -1;

    public Student(String name, int age, String studentNumber) {
        super(name, age);
        this.setStudentNumber(studentNumber);
    }

    /**
     * @param studentNumber
     */
    @Override
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    /**
     * @return the studentNumber
     */
    @Override
    public String getStudentNumber() {
        return this.studentNumber;
    }

    /**
     * @return the grades
     */
    @Override
    public List<ISubject> getGrades() {
        return grades;
    }

    /**
     * @param newSubject
     * @param grade
     */
    @Override
    public void addGrade(ISubject newSubject) {
        // find the subject in the grades list by subject name
        ISubject subject = this.grades.stream().filter(s -> newSubject.getName().equals(s.getName())).findFirst()
                .orElse(null);
        // if subject has been found change the grade, else add the subject to the list
        // with grade
        if (subject != null) {
            subject.setGrade(newSubject.getGrade());
        } else {
            this.grades.add(newSubject);
        }
    }

    private void calculateAverage() {
        this.average = this.grades.stream().map(ISubject::getGrade).reduce(0.0, Double::sum) / this.grades.size();
    }

    @Override
    public double getAverage() {
        if (this.average == -1) {
            this.calculateAverage();
        }
        return this.average;
    }

    public String toListEntry() {
        return String.format("Student %s - %s", this.getName(), this.getStudentNumber());
    }

}
