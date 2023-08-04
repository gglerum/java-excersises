package javales.src.lessons.lesson2.studentenlijst;

public interface IPerson {

    void setName(String name);

    /**
     * @return the name
     */
    String getName();

    /**
     * @return the age
     */
    int getAge();

    void setAge(int age);

}