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

}
