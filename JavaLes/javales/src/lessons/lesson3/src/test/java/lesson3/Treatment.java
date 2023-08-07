package lesson3;

import java.time.LocalDateTime;

import lesson3.store.TreatmentType;

public class Treatment extends lesson3.store.Record {
    public String name;
    public String description;
    public TreatmentType type;

    /**
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

}
