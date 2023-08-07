package lesson3.store;

import java.time.LocalDateTime;

public class Treatment extends Record implements ITreatment {

    private String name;
    private String description;
    private TreatmentType type;

    /**
     * @param createdDateTime
     * @param id
     * @param name
     * @param description
     * @param type
     */
    public Treatment(LocalDateTime createdDateTime, long id, String name, String description, TreatmentType type) {
        super(createdDateTime, id);
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public Treatment(LocalDateTime createdDateTime, long id) {
        super(createdDateTime, id);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setType(TreatmentType type) {
        this.type = type;
    }

    @Override
    public TreatmentType getType() {
        return this.type;
    }

}
