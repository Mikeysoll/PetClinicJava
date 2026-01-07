package tests.pets;

import base.TestBase;
import dto.pet.PetResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static specs.PetSpecs.getAllPets;

public class GetPetListTest extends TestBase {
    @Test
    public void getPetList() {
        PetResponse[] pets = getAllPets();

        assertTrue(pets.length > 0, "Список питомцев не должен быть пустым");
    }
}
