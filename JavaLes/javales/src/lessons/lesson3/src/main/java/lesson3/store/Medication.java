package lesson3.store;

import java.time.LocalDateTime;

public class Medication extends Treatment implements IMedication {

    /**
     * @param createdDateTime
     * @param id
     * @param name
     * @param description
     * @param type
     */
    public Medication(LocalDateTime createdDateTime, long id, String name, String description, TreatmentType type) {
        super(createdDateTime, id, name, description, type);
    }

    public Medication(LocalDateTime createdDateTime, long id) {
        super(createdDateTime, id);
    }

}
