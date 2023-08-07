package lesson3.store;

import java.time.LocalDateTime;
import java.util.List;

public class Appointment extends Record implements IAppointment {

    private IVet vet;
    private IPet pet;
    private String complaints;
    private List<IDiagnosis> diagnoses;
    private List<ITreatmentPlan> treatmentPlans;
    private String notes;

    /**
     * @param createdDateTime
     * @param id
     */
    public Appointment(LocalDateTime createdDateTime, long id) {
        super(createdDateTime, id);
    }

    /**
     * @param vet
     * @param pet
     * @param complaints
     * @param diagnoses
     * @param treatmentPlans
     * @param notes
     */
    public Appointment(LocalDateTime createdDateTime, long id, IVet vet, IPet pet, String complaints) {
        super(createdDateTime, id);
        this.vet = vet;
        this.pet = pet;
        this.complaints = complaints;
    }

    @Override
    public void setVet(IVet vet) {
        this.vet = vet;
    }

    @Override
    public IVet getVet() {
        return this.vet;
    }

    @Override
    public void setPet(IPet pet) {
        this.pet = pet;
    }

    @Override
    public IPet getPet() {
        return this.pet;
    }

    @Override
    public void setComplaints(String complaints) {
        this.complaints = complaints;
    }

    @Override
    public String getComplaints() {
        return this.complaints;
    }

    @Override
    public void setDiagnoses(List<IDiagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

    @Override
    public List<IDiagnosis> getDiagnoses() {
        return this.diagnoses;
    }

    @Override
    public void setTreatmentPlans(List<ITreatmentPlan> treatmentPlans) {
        this.treatmentPlans = treatmentPlans;
    }

    @Override
    public List<ITreatmentPlan> getTreatmentPlans() {
        return this.treatmentPlans;
    }

    @Override
    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String getNotes() {
        return this.notes;
    }

}
