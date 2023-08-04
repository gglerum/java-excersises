package javales.src.lessons.lesson2.studentenlijst;

public abstract class Person implements IPerson {

    private String name;

    private int age;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * @return the age
     */
    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    protected Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

}
