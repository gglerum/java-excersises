package javales.src.lessons.lesson2.studentenlijst;

public class Subject {

    private String name;

    private double grade;

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the grade
     */
    public double getGrade() {
        return this.grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Subject(String name, double grade) {
        this.setName(name);
        this.setGrade(grade);
    }
}