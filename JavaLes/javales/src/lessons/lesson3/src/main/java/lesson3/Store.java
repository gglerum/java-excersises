package lesson3;

import java.util.List;

import lesson3.store.IDiagnosis;
import lesson3.store.IOwner;
import lesson3.store.IPet;
import lesson3.store.ITreatment;
import lesson3.store.IVet;
import lesson3.store.Species;

public class Store {

    private Store() {

    }

    private static List<IVet> vets;

    private static List<IOwner> owners;

    private static List<IDiagnosis> diagnoses;

    private static List<IPet> pets;

    private static List<ITreatment> treatments;

    private static List<Species> species;

    /**
     * @return the vets
     */
    public static List<IVet> getVets() {
        return vets;
    }

    /**
     * @param vets the vets to set
     */
    public static void setVets(List<IVet> vets) {
        Store.vets = vets;
    }

    /**
     * @return the owners
     */
    public static List<IOwner> getOwners() {
        return owners;
    }

    /**
     * @param owners the owners to set
     */
    public static void setOwners(List<IOwner> owners) {
        Store.owners = owners;
    }

    /**
     * @return the diagnoses
     */
    public static List<IDiagnosis> getDiagnoses() {
        return diagnoses;
    }

    /**
     * @param diagnoses the diagnoses to set
     */
    public static void setDiagnoses(List<IDiagnosis> diagnoses) {
        Store.diagnoses = diagnoses;
    }

    /**
     * @return the pets
     */
    public static List<IPet> getPets() {
        return pets;
    }

    /**
     * @param pets the pets to set
     */
    public static void setPets(List<IPet> pets) {
        Store.pets = pets;
    }

    /**
     * @return the treatments
     */
    public static List<ITreatment> getTreatments() {
        return treatments;
    }

    /**
     * @param treatments the treatments to set
     */
    public static void setTreatments(List<ITreatment> treatments) {
        Store.treatments = treatments;
    }

    /**
     * @return the species
     */
    public static List<Species> getSpecies() {
        return species;
    }

    /**
     * @param species the species to set
     */
    public static void setSpecies(List<Species> species) {
        Store.species = species;
    }

}
