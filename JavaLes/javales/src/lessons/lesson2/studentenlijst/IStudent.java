package javales.src.lessons.lesson2.studentenlijst;

import java.util.List;

public interface IStudent extends IPerson {

    /**
     * @param studentNumber
     */
    void setStudentNumber(String studentNumber);

    /**
     * @return the studentNumber
     */
    String getStudentNumber();

    /**
     * @return the grades
     */
    List<ISubject> getGrades();

    /**
     * @param newSubject
     * @param grade
     */
    void addGrade(ISubject newSubject);

    double getAverage();

}