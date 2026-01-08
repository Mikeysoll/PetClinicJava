package specs;

import base.RequestSpec;
import base.ResponseSpec;
import com.github.javafaker.Faker;
import dto.specialty.SpecialtyRequest;
import dto.specialty.SpecialtyResponse;
import dto.vet.VetRequest;
import dto.vet.VetResponse;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class VetSpecs {

    @Step("Create a random vet")
    public static VetResponse createRandomVet() {
        Faker faker  = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        List<SpecialtyRequest> specialties = new ArrayList<>();
        specialties.add(new SpecialtyRequest("anesthesiologist"));

        return given()
                .spec(RequestSpec.baseRequestSpec())
                .body(new  VetRequest(firstName, lastName, specialties))
                .when()
                .post("/api/vets")
                .then()
                .spec(ResponseSpec.created201())
                .extract().as(VetResponse.class);
    }
}
