package specs;

import base.RequestSpec;
import base.ResponseSpec;
import dto.owner.OwnerRequest;
import dto.owner.OwnerResponse;
import io.qameta.allure.Step;

import static base.TestData.faker;
import static io.restassured.RestAssured.given;

public class OwnerSpecs {

    @Step("Generating owner data")
    private static OwnerRequest generateOwnerData() {
        return new OwnerRequest(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.address().fullAddress(),
                faker.address().city(),
                faker.number().digits(10)
        );
    }

    @Step("Create a random owner")
    public static OwnerResponse createRandomOwner() {
        OwnerRequest request = generateOwnerData();

        return given()
                .spec(RequestSpec.baseRequestSpec())
                .log().body()
                .body(request)
                .when()
                .post("/api/owners")
                .then()
                .log().ifValidationFails()
                .log().body()
                .spec(ResponseSpec.created201())
                .extract().as(OwnerResponse.class);
    }

    @Step("Full owner update (ownerId = {ownerId})")
    public static OwnerResponse updateOwner(int ownerId) {
        OwnerRequest newOwnerData = generateOwnerData();

        given()
                .spec(RequestSpec.baseRequestSpec())
                .log().body()                 // новые данные
                .body(newOwnerData)
                .when()
                .put("/api/owners/{ownerId}", ownerId)
                .then()
                .log().ifValidationFails()
                .spec(ResponseSpec.noContent204());
        return getOwnerById(ownerId);
    }

    @Step("Get all owners")
    public static OwnerResponse[] getAllOwners() {
        return given()
                .spec(RequestSpec.baseRequestSpec())
                .when()
                .get("/api/owners")
                .then()
                .log().ifValidationFails()
                .log().body()
                .spec(ResponseSpec.ok200())
                .extract().as(OwnerResponse[].class);
    }

    @Step("Get owner by ID: {ownerId}")
    public static OwnerResponse getOwnerById(int ownerId) {
        return given()
                .spec(RequestSpec.baseRequestSpec())
                .when()
                .get("/api/owners/{ownerId}", ownerId)
                .then()
                .log().ifValidationFails()
                .log().body()
                .spec(ResponseSpec.ok200())
                .extract().as(OwnerResponse.class);
    }

    @Step("Delete owner by ID: {ownerId}")
    public static void deleteOwner(int ownerId) {
        given()
                .spec(RequestSpec.baseRequestSpec())
                .when()
                .delete("/api/owners/{ownerId}", ownerId)
                .then()
                .log().ifValidationFails()
                .spec(ResponseSpec.noContent204());
    }
}
