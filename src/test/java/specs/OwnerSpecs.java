package specs;


import base.RequestSpec;
import base.ResponseSpec;
import com.github.javafaker.Faker;
import dto.owner.OwnerRequest;
import dto.owner.OwnerResponse;
import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;

public class OwnerSpecs {

    @Step("Create a random owner")
    public static OwnerResponse createRandomOwner() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String address = faker.address().fullAddress();
        String city = faker.address().city();
        String telephone = faker.number().digits(10);

        OwnerRequest request = new OwnerRequest(firstName, lastName, address, city, telephone);

        return given()
                .spec(RequestSpec.baseRequestSpec())
                .body(request)
                .when()
                .post("/api/owners")
                .then()
                .log().body()
                .spec(ResponseSpec.created201())
                .extract().as(OwnerResponse.class);
    }

    @Step("Get all owners")
    public static OwnerResponse[] getAllOwners() {
        return given()
                .spec(RequestSpec.baseRequestSpec())
                .when()
                .get("/api/owners")
                .then()
                .log().body()
                .spec(ResponseSpec.ok200())
                .extract().as(OwnerResponse[].class);
    }

    @Step("Delete owner by ID: {id}")
    public static void deleteOwner(int id) {
        given()
                .spec(RequestSpec.baseRequestSpec())
                .when()
                .delete("/api/owners/" + id)
                .then()
                .log().body()
                .spec(ResponseSpec.noContent204());
    }

    @Step("Get owner by ID: {ownerId}")
    public static OwnerResponse getOwnerById(int ownerId) {
        return given()
                .spec(RequestSpec.baseRequestSpec())
                .when()
                .get("/api/owners/{ownerId}", ownerId)
                .then()
                .spec(ResponseSpec.ok200())
                .extract().as(OwnerResponse.class);
    }
}
