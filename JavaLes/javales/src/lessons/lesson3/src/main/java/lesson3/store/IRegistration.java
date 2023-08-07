package lesson3.store;

import java.util.List;

public interface IRegistration {

    /**
     * Get appointments
     */
    List<IAppointment> getAppointments();

    /**
     * set appointments
     *
     * @return void
     */
    void setAppointments(List<IAppointment> appointments);

    /**
     * Get treatment plans from appointments
     */
    List<ITreatmentPlan> getTreatmentPlans();

    /**
     * Get medications
     */
    List<IMedication> getMedications();

    /**
     * Get operations
     */
    List<IOperation> getOperations();

    /**
     * Get diagnoses
     */
    List<IDiagnosis> getDiagnoses();

}