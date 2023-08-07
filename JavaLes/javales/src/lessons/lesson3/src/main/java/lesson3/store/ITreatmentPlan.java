package lesson3.store;

import java.util.List;

public interface ITreatmentPlan extends IRecord {

    /**
     * @param species the treatment plan is meant for
     */
    public void setSpecies(Species species);

    /**
     * @return species the treatment plan is meant for
     */
    public Species getSpecies();

    /**
     * @param diagnosis the treatment plan is suggested for
     */
    public void setDiagnosis(IDiagnosis diagnosis);

    /**
     * @return diagnosis the treatment plan is suggested for
     */
    public IDiagnosis getDiagnosis();

    /**
     * @param treatments recommended by the vet
     */
    public void setTreatments(List<ITreatment> treatments);

    /**
     * @return treatments recommended by the vet
     */
    public List<ITreatment> getTreatments();

    /**
     * @param <T>  Interface
     * @param type Interface we want the treatments to be filtered on
     * @return list of treatments that are an instance of given Interface
     */
    public <T extends ITreatment> List<T> getTreatmentsByType(Class<T> type);

}
