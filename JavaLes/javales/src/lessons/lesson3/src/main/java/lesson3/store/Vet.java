package lesson3.store;

import java.time.LocalDateTime;

public class Vet extends Person implements IVet {

    /**
     * @param createdDateTime
     * @param id
     * @param name
     */
    public Vet(LocalDateTime createdDateTime, long id, String name) {
        super(createdDateTime, id, name);
    }

    /**
     * @param createdDateTime
     * @param id
     */
    public Vet(LocalDateTime createdDateTime, long id) {
        super(createdDateTime, id);
    }

}
