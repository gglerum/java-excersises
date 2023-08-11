package lesson3;

import java.util.ArrayList;

import org.instancio.Instancio;
import org.instancio.Select;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import lesson3.store.Diagnosis;
import lesson3.store.Treatment;

public class StoreTest {

    @BeforeAll
    public static void createData() {
        Store.setTreatments(new ArrayList<>(
                Instancio.ofList(Treatment.class).size(10).create()));

        Store.setDiagnoses(new ArrayList<>(
                Instancio.ofList(Diagnosis.class).size(10)
                        .ignore(Select.field(Diagnosis::getTreatmentPlans))
                        .create()));
    }

    @Test
    public void dataIsPopulated() {
        Assertions.assertEquals(10, Store.getTreatments().size());
    }

}
