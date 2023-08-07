package lesson3.store;

import java.time.LocalDateTime;

public class TreatmentFactory {

    private TreatmentFactory() {

    }

    public static ITreatment create(LocalDateTime createdDateTime, long id, String name, String description,
            TreatmentType type) {
        switch (type) {
            case MEDICATION:
                return new Medication(createdDateTime, id, name, description, type);
            case OPERATION:
                return new Operation(createdDateTime, id, name, description, type);
            default:
                return new Treatment(createdDateTime, id, name, description, type);
        }
    }

}
