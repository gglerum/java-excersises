package lesson3.store;

import java.util.List;

public interface IDiagnosis extends IRecord {

    /**
     * @param name set name of diagnosis
     */
    public void setName(String name);

    /**
     * @return get name of diagnosis
     */
    public String getName();

    /**
     * @param description of diagnosis
     */
    public void setDescription(String description);

    /**
     * @return description of diagnosis
     */
    public String getDescription();

    /**
     * @param treatmentPlans that are suggested for diagnosis
     */
    public void setTreatmentPlans(List<ITreatmentPlan> treatmentPlans);

    /**
     * @return suggested treatment plans
     */
    public List<ITreatmentPlan> getTreatmentPlans();

}
