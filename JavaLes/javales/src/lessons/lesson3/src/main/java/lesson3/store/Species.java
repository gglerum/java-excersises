package lesson3.store;

import java.time.LocalDateTime;

public class Species extends Record {

    private String name;

    private String description;

    /**
     * @param createdDateTime
     * @param id
     * @param name
     * @param description
     */
    public Species(LocalDateTime createdDateTime, long id, String name, String description) {
        super(createdDateTime, id);
        this.name = name;
        this.description = description;
    }

    /**
     * @param createdDateTime
     * @param id
     */
    public Species(LocalDateTime createdDateTime, long id) {
        super(createdDateTime, id);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
