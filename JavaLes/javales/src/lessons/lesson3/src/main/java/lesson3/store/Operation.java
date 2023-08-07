package lesson3.store;

import java.time.LocalDateTime;

public class Operation extends Treatment implements IOperation {

    /**
     * @param createdDateTime
     * @param id
     * @param name
     * @param description
     * @param type
     */
    public Operation(LocalDateTime createdDateTime, long id, String name, String description, TreatmentType type) {
        super(createdDateTime, id, name, description, type);
    }

    /**
     * @param createdDateTime
     * @param id
     */
    public Operation(LocalDateTime createdDateTime, long id) {
        super(createdDateTime, id);
    }

}
