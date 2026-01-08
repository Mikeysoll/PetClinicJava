package specs;

import base.RequestSpec;
import base.ResponseSpec;
import com.github.javafaker.Faker;
import dto.pet.PetRequest;
import dto.pet.PetRequestWithTypeId;
import dto.pet.PetResponse;
import dto.pettype.PetTypeRequest;
import dto.pettype.PetTypeRequestWithId;
import dto.pettype.PetTypeResponse;
import io.qameta.allure.Step;

import java.text.SimpleDateFormat;
import java.util.Date;

import static io.restassured.RestAssured.given;

public class PetSpecs {

    @Step("Create a random pet for owner ID: {ownerId}")
    public static PetResponse createRandomPet(int ownerId) throws Exception {

        Faker faker = new Faker();
        String name = faker.name().firstName();

        String birthDateStr = new SimpleDateFormat("yyyy-MM-dd")
                .format(faker.date().between(new SimpleDateFormat("yyyy-MM-dd").parse("2010-01-01"), new Date()));

        PetTypeResponse randomType = PetTypeSpecs.createRandomPetType();
        PetTypeRequestWithId typeRequest = new PetTypeRequestWithId(randomType.getId(), randomType.getName());

        return given()
                .spec(RequestSpec.baseRequestSpec())
                .body(new PetRequestWithTypeId(name, birthDateStr, typeRequest))
                .when()
                .post("/api/owners/{ownerId}/pets", ownerId)
                .then()
                .log().body()
                .spec(ResponseSpec.created201())
                .extract().as(PetResponse.class);
    }

    @Step("Get pet by ID: {petId}")
    public static PetResponse getPetById(int petId) {
        return given()
                .spec(RequestSpec.baseRequestSpec())
                .when()
                .get("/api/pets/{petId}", petId)
                .then()
                .spec(ResponseSpec.ok200())
                .extract().as(PetResponse.class);
    }
}
