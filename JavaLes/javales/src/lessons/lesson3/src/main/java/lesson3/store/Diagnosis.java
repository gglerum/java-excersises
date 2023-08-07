package lesson3.store;

import java.time.LocalDateTime;
import java.util.List;

public class Diagnosis extends Record implements IDiagnosis {

    private String name;
    private String description;
    private List<ITreatmentPlan> treatmentPlans;

    /**
     * @param createdDateTime
     * @param id
     */
    public Diagnosis(LocalDateTime createdDateTime, long id) {
        super(createdDateTime, id);
    }

    /**
     * @param createdDateTime
     * @param id
     * @param name
     * @param description
     * @param treatmentPlans
     */
    public Diagnosis(LocalDateTime createdDateTime, long id, String name, String description,
            List<ITreatmentPlan> treatmentPlans) {
        super(createdDateTime, id);
        this.name = name;
        this.description = description;
        this.treatmentPlans = treatmentPlans;
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
    public void setTreatmentPlans(List<ITreatmentPlan> treatmentPlans) {
        this.treatmentPlans = treatmentPlans;
    }

    @Override
    public List<ITreatmentPlan> getTreatmentPlans() {
        return this.treatmentPlans;
    }

}
