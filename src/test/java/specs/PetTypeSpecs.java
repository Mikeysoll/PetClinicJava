package specs;

import base.RequestSpec;
import base.ResponseSpec;
import com.github.javafaker.Faker;
import dto.pettype.PetTypeRequest;
import dto.pettype.PetTypeResponse;
import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;

public class PetTypeSpecs {

    @Step("Create a random pet type")
    public static PetTypeResponse createRandomPetType() {
        Faker faker = new Faker();
        String randomName = faker.animal().name();
        PetTypeRequest request = new PetTypeRequest(randomName);

        return given()
                .spec(RequestSpec.baseRequestSpec())
                .body(request)
                .when()
                .post("/api/pettypes")
                .then()
                .spec(ResponseSpec.created201())
                .extract().as(PetTypeResponse.class);
    }

    @Step("Delete pet type by ID: {id}")
    public static void deletePetType(int id) {
        given()
                .spec(RequestSpec.baseRequestSpec())
                .when()
                .delete("/api/pettypes/{id}", id)
                .then()
                .spec(ResponseSpec.noContent204());
    }
}
