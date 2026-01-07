package tests.pets;

import base.RequestSpec;
import base.TestBase;
import dto.pettype.PetTypeResponse;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import specs.PetTypeSpecs;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DeletePetTest extends TestBase {

    @Test
    @Tag("pet")
    public void deletePetTest() {
        PetTypeResponse pet = PetTypeSpecs.createRandomPetType();

        assertNotNull(pet.getId());
        assertNotNull(pet.getName());

        PetTypeSpecs.deletePetType(pet.getId());

        int statusCode =
                given()
                        .spec(RequestSpec.baseRequestSpec())
                        .when()
                        .get("/api/pettypes/{id}", pet.getId())
                        .getStatusCode();
        assertEquals(404, statusCode);
    }
}
