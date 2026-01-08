package specs;

import base.RequestSpec;
import base.ResponseSpec;
import dto.specialty.SpecialtyRequest;
import dto.specialty.SpecialtyResponse;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SpecialtySpecs {
    @Step("Create a specialty with name: anesthesiologist")
    public static SpecialtyResponse createSpecialty() {
        return given()
                .spec(RequestSpec.baseRequestSpec())
                .body(new SpecialtyRequest("anesthesiologist"))
                .when()
                .post("/api/specialties")
                .then()
                .spec(ResponseSpec.created201())
                .extract().body().as(SpecialtyResponse.class);
    }
}
