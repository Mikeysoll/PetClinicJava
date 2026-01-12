package specs;

import base.RequestSpec;
import base.ResponseSpec;
import dto.specialty.SpecialtyRequest;
import dto.specialty.SpecialtyResponse;
import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;

public class SpecialtySpecs {
    public static final String SPECIALITY = "anesthesiologist";

    @Step("Create a specialty")
    public static SpecialtyResponse createSpecialty() {
        return given()
                .spec(RequestSpec.baseRequestSpec())
                .body(new SpecialtyRequest(SPECIALITY))
                .when()
                .post("/api/specialties")
                .then()
                .spec(ResponseSpec.created201())
                .extract().body().as(SpecialtyResponse.class);
    }
}
