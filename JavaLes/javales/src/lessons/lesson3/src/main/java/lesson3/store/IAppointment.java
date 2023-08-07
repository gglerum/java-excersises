package lesson3.store;

import java.util.List;

public interface IAppointment extends IRecord {

    /**
     * @param vet the treating veterinarian
     */
    public void setVet(IVet vet);

    /**
     * @return the treating veterinarian
     */
    public IVet getVet();

    /**
     * @param pet that had an appointment
     */
    public void setPet(IPet pet);

    /**
     * @return pet that had an appointment
     */
    public IPet getPet();

    /**
     * @param complaints that the pet is experiencing
     */
    public void setComplaints(String complaints);

    /**
     * @return description of the complaints the pet experiences
     */
    public String getComplaints();

    /**
     * @param diagnoses the diagnoses of the pet during the appointment
     */
    public void setDiagnoses(List<IDiagnosis> diagnoses);

    /**
     * @return diagnoses of the pet during the appointment
     */
    public List<IDiagnosis> getDiagnoses();

    /**
     * @param treatmentPlans suggested during appointment, for each diagnosis
     */
    public void setTreatmentPlans(List<ITreatmentPlan> treatmentPlans);

    /**
     * @return treatment plan suggested during appointment
     */
    public List<ITreatmentPlan> getTreatmentPlans();

    /**
     * @param notes notes for appointment
     */
    public void setNotes(String notes);

    /**
     * @return notes for appointment
     */
    public String getNotes();
}
