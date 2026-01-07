package tests.pets;

import base.TestBase;
import dto.pet.PetResponse;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import specs.PetSpecs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static specs.PetSpecs.*;

public class CreatePetTest extends TestBase {

    @Test
    @Tag("pet")
    public void createPetTest() {
        PetResponse pet = createPet("kitten");

        assertNotNull(pet.getId(),"ID должен быть сгенерирован");
        assertEquals("kitten",pet.getName());
    }

    @Test
    public void createRandomPet() {
        PetResponse pet = PetSpecs.createRandomPet();

        assertNotNull(pet.getId());
        assertNotNull(pet.getName());
    }
}
