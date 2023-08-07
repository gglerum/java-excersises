package lesson3.store;

import java.time.LocalDateTime;
import java.util.List;

public class TreatmentPlan extends Record implements ITreatmentPlan {

    private Species species;
    private IDiagnosis diagnosis;
    private List<ITreatment> treatments;

    /**
     * @param createdDateTime
     * @param id
     * @param species
     * @param diagnosis
     * @param treatments
     */
    public TreatmentPlan(LocalDateTime createdDateTime, long id, Species species, IDiagnosis diagnosis,
            List<ITreatment> treatments) {
        super(createdDateTime, id);
        this.species = species;
        this.diagnosis = diagnosis;
        this.treatments = treatments;
    }

    /**
     * @param createdDateTime
     * @param id
     */
    public TreatmentPlan(LocalDateTime createdDateTime, long id) {
        super(createdDateTime, id);
    }

    @Override
    public void setSpecies(Species species) {
        this.species = species;
    }

    @Override
    public Species getSpecies() {
        return this.species;
    }

    @Override
    public void setDiagnosis(IDiagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public IDiagnosis getDiagnosis() {
        return this.diagnosis;
    }

    @Override
    public void setTreatments(List<ITreatment> treatments) {
        this.treatments = treatments;
    }

    @Override
    public List<ITreatment> getTreatments() {
        return this.treatments;
    }

    @Override
    public <T extends ITreatment> List<T> getTreatmentsByType(Class<T> type) {
        return this.treatments.stream()
                .filter(type::isInstance)
                .map(type::cast).toList();
    }

}
