package specs;

import base.RequestSpec;
import base.ResponseSpec;
import com.github.javafaker.Faker;
import dto.pet.PetRequest;
import dto.pet.PetResponse;
import dto.pettype.PetTypeRequestWithId;
import dto.pettype.PetTypeResponse;
import io.qameta.allure.Step;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static io.restassured.RestAssured.given;

public class PetSpecs {

    @Step("Create a random pet for owner ID: {ownerId}")
    public static PetResponse createRandomPet(int ownerId) throws ParseException {

        Faker faker = new Faker();
        String name = faker.name().firstName();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse("2010-01-01");
        String birthDateStr = sdf.format(faker.date().between(startDate, new Date()));

        PetTypeResponse randomType = PetTypeSpecs.createRandomPetType();
        PetTypeRequestWithId typeRequest = new PetTypeRequestWithId(randomType.getId(), randomType.getName());

        PetRequest request = new PetRequest(name, birthDateStr, typeRequest);

        return given()
                .spec(RequestSpec.baseRequestSpec())
                .body(request)
                .when()
                .post("/api/owners/{ownerId}/pets", ownerId)
                .then()
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
