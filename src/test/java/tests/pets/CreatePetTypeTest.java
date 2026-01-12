package tests.pets;

import base.TestBase;
import dto.pettype.PetTypeResponse;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import specs.PetTypeSpecs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static specs.PetTypeSpecs.*;

@Tag("pet")
public class CreatePetTypeTest extends TestBase {

    @Test
    public void createRandomPet() {
        PetTypeResponse pet = PetTypeSpecs.createRandomPetType();

        assertNotNull(pet.getId(),"ID должен быть сгенерирован");
        assertNotNull(pet.getName());
    }
}
