package lesson3.store;

import java.time.LocalDateTime;
import java.util.List;

import lesson3.Utils;

public class Owner extends Person implements IOwner {

    private List<IPet> pets;

    /**
     * @param createdDateTime
     * @param id
     * @param pets
     * @param name
     */
    public Owner(LocalDateTime createdDateTime, long id, String name, List<IPet> pets) {
        super(createdDateTime, id, name);
        this.pets = pets;
    }

    /**
     * @param createdDateTime
     * @param id
     */
    public Owner(LocalDateTime createdDateTime, long id) {
        super(createdDateTime, id);
    }

    /**
     * get appointments for all pets
     */
    @Override
    public List<IAppointment> getAppointments() {
        return Utils.joinSubLists(this.pets, IPet::getAppointments);
    }

    /**
     * get treatment plans for all pets
     */
    @Override
    public List<ITreatmentPlan> getTreatmentPlans() {
        return Utils.joinSubLists(this.getAppointments(), IAppointment::getTreatmentPlans);
    }

    /**
     * get medication for all pets
     */
    @Override
    public List<IMedication> getMedications() {
        return Utils.joinSubLists(this.pets, IPet::getMedications);
    }

    /**
     * get medication for all pets
     */
    @Override
    public List<IDiagnosis> getDiagnoses() {
        return Utils.joinSubLists(this.pets, IPet::getDiagnoses);
    }

    @Override
    public List<IPet> getPets() {
        return this.pets;
    }

    @Override
    public void setPets(List<IPet> pets) {
        this.pets = pets;
    }

    @Override
    public void setAppointments(List<IAppointment> appointments) {
        throw new UnsupportedOperationException("Unimplemented method 'setAppointments'");
    }

    @Override
    public List<IOperation> getOperations() {
        return Utils.joinSubLists(this.pets, IPet::getOperations);
    }

}
