package specs;

import base.RequestSpec;
import base.ResponseSpec;
import com.github.javafaker.Faker;
import dto.pet.PetRequest;
import dto.pet.PetResponse;

import static io.restassured.RestAssured.given;

public class PetSpecs {

    public static PetResponse createPet(String name) {
        PetRequest request = new PetRequest(name);

        return given()
                .spec(RequestSpec.baseRequestSpec())
                .body(request)
                .when()
                .post("/api/pettypes")
                .then()
                .log().body()
                .spec(ResponseSpec.created201())
                .extract().as(PetResponse.class);
    }

    public static PetResponse createRandomPet() {
        Faker faker = new Faker();
        String randomName = faker.animal().name();
        return createPet(randomName);
    }

    public static PetResponse[] getAllPets() {
        return given()
                .spec(RequestSpec.baseRequestSpec())
                .when()
                .get("/api/pettypes")
                .then()
                .log().body()
                .spec(ResponseSpec.ok200())
                .extract().as(PetResponse[].class);
    }

    public static void deletePet(int id) {
        given()
                .spec(RequestSpec.baseRequestSpec())
                .when()
                .delete("/api/pettypes/{id}", id)
                .then()
                .log().body()
                .spec(ResponseSpec.noContent204());
    }
}
