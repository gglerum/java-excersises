package javales.src.lessons.lesson2.studentenlijst;

public abstract class Person {

    private String name;

    private int age;

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    protected Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
