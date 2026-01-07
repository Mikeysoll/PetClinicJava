package tests.pets;

import base.TestBase;
import dto.pettype.PetTypeResponse;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static specs.PetTypeSpecs.getAllPetTypes;

public class GetPetListTest extends TestBase {

    @Test
    @Tag("pet")
    public void getPetList() {
        PetTypeResponse[] pets = getAllPetTypes();

        assertTrue(pets.length > 0, "Список питомцев не должен быть пустым");
    }
}
