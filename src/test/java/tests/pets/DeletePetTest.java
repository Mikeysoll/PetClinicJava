package tests.pets;

import base.RequestSpec;
import base.TestBase;
import dto.pet.PetResponse;
import org.junit.jupiter.api.Test;
import specs.PetSpecs;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DeletePetTest extends TestBase {

    @Test
    public void deletePetTest() {
        PetResponse pet = PetSpecs.createRandomPet();

        assertNotNull(pet.getId());
        assertNotNull(pet.getName());

        PetSpecs.deletePet(pet.getId());

        int statusCode =
                given()
                        .spec(RequestSpec.baseRequestSpec())
                        .when()
                        .get("/api/pettypes/{id}", pet.getId())
                        .getStatusCode();
        assertEquals(404, statusCode);
    }
}
