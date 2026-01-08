package specs;

import base.RequestSpec;
import base.ResponseSpec;
import com.github.javafaker.Faker;
import dto.vet.VetResponse;
import dto.visit.VisitRequest;
import dto.visit.VisitResponse;
import io.qameta.allure.Step;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static io.restassured.RestAssured.given;

public class VisitSpecs {

    @Step("Create a random visit for pet ID: {petId}, owner ID: {ownerId}")
    public static VisitResponse createRandomVisit(int petId, int ownerId) throws ParseException {
        Faker faker = new Faker();
        String[] description = {
                "Parvovirus",
                "Feline Leukemia",
                "Arthritis",
                "Dermatitis",
                "Gastroenteritis",
                "Respiratory Infection",
                "Ear Infection",
                "Fleas or Parasites",
                "Diabetes",
                "Obesity"
        };

        String randomDisease = faker.options().option(description);

        String date = new SimpleDateFormat("yyyy-MM-dd")
                .format(faker.date().between(new Date(), new SimpleDateFormat("yyyy-MM-dd").parse("2027-01-01")));

        return given()
                .spec(RequestSpec.baseRequestSpec())
                .body(new VisitRequest(date, randomDisease))
                .when()
                .post("/api/owners/" + ownerId + "/pets/"+ petId + "/visits")
                .then()
                .spec(ResponseSpec.created201())
                .extract().as(VisitResponse.class);
    }

    @Step("Get visit by ID: {visitId}")
    public static VisitResponse getVisitById(int visitId) {
        return given()
                .spec(RequestSpec.baseRequestSpec())
                .when()
                .get("/api/visits/{visitId}", visitId)
                .then()
                .spec(ResponseSpec.ok200())
                .extract().as(VisitResponse.class);
    }
}
