package tests.pets;

import base.TestBase;
import dto.pettype.PetTypeResponse;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import specs.PetTypeSpecs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static specs.PetTypeSpecs.*;

public class CreatePetTest extends TestBase {

    @Test
    @Tag("pet")
    public void createPetTest() {
        PetTypeResponse pet = createPet("kitten");

        assertNotNull(pet.getId(),"ID должен быть сгенерирован");
        assertEquals("kitten",pet.getName());
    }

    @Test
    public void createRandomPet() {
        PetTypeResponse pet = PetTypeSpecs.createRandomPetType();

        assertNotNull(pet.getId());
        assertNotNull(pet.getName());
    }
}
