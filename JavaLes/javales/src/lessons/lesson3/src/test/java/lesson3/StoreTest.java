package lesson3;

import java.util.List;

import org.instancio.Instancio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

public class StoreTest {

    @Test
    public void createTreatments() {

        List<Treatment> mockTreatments = Instancio.ofList(Treatment.class).size(10).create();

        Assertions.assertEquals(mockTreatments.size(), 10);

    }

}
