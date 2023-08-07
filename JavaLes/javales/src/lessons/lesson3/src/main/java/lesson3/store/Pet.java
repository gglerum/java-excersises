package lesson3.store;

import java.time.LocalDateTime;
import java.util.List;

import lesson3.Utils;

public class Pet extends Record implements IPet {

    private List<IAppointment> appointments;
    private String name;
    private Species species;
    private IOwner owner;
    private Sex sex;

    /**
     * @param createdDateTime
     * @param id
     * @param name
     * @param species
     * @param owner
     */
    public Pet(LocalDateTime createdDateTime, long id, String name, Species species, IOwner owner) {
        super(createdDateTime, id);
        this.name = name;
        this.species = species;
        this.owner = owner;
    }

    /**
     * @param createdDateTime
     * @param id
     */
    public Pet(LocalDateTime createdDateTime, long id) {
        super(createdDateTime, id);
    }

    @Override
    public List<IAppointment> getAppointments() {
        return this.appointments;
    }

    @Override
    public void setAppointments(List<IAppointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public List<ITreatmentPlan> getTreatmentPlans() {
        return Utils.joinSubLists(this.appointments, IAppointment::getTreatmentPlans);
    }

    @Override
    public List<IDiagnosis> getDiagnoses() {
        return Utils.joinSubLists(this.appointments, IAppointment::getDiagnoses);
    }

    /**
     * Get medications prescribed to pet
     */
    @Override
    public List<IMedication> getMedications() {
        return Utils.joinSubLists(this.getTreatmentPlans(),
                tp -> tp.getTreatmentsByType(IMedication.class));
    }

    /**
     * Get operations performed on pet
     */
    @Override
    public List<IOperation> getOperations() {
        return Utils.joinSubLists(this.getTreatmentPlans(),
                tp -> tp.getTreatmentsByType(IOperation.class));
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Species getSpecies() {
        return this.species;
    }

    @Override
    public void setSpecies(Species species) {
        this.species = species;
    }

    @Override
    public void setOwner(IOwner owner) {
        this.owner = owner;
    }

    @Override
    public IOwner getOwner() {
        return this.owner;
    }

    @Override
    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public Sex getSex() {
        return this.sex;
    }

}
