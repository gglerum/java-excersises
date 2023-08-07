package lesson3.store;

import java.time.LocalDateTime;

public class Person extends Record implements IPerson {

    private String name;

    /**
     * @param createdDateTime
     * @param id
     * @param name
     */
    public Person(LocalDateTime createdDateTime, long id, String name) {
        super(createdDateTime, id);
        this.name = name;
    }

    /**
     * @param createdDateTime
     * @param id
     */
    public Person(LocalDateTime createdDateTime, long id) {
        super(createdDateTime, id);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

}
