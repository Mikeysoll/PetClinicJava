package specs;


import base.RequestSpec;
import base.ResponseSpec;
import com.github.javafaker.Faker;
import dto.owner.OwnerRequest;
import dto.owner.OwnerResponse;

import static io.restassured.RestAssured.given;

public class OwnerSpecs {

    public static OwnerResponse createOwner(String firstName, String lastName, String address, String city, String telephone) {
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

    public static OwnerResponse createRandomOwner() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String address = faker.address().fullAddress();
        String city = faker.address().city();
        String telephone = faker.number().digits(10);
        return createOwner(firstName, lastName, address, city, telephone);
    }

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

    public static void deleteOwner(int id) {
        given()
                .spec(RequestSpec.baseRequestSpec())
                .when()
                .delete("/api/owners/" + id)
                .then()
                .log().body()
                .spec(ResponseSpec.noContent204());
    }

    public static OwnerResponse getOwnerById(int id) {
        return given()
                .spec(RequestSpec.baseRequestSpec())
                .when()
                .get("/api/owners/{id}" + id)
                .then()
                .log().body()
                .spec(ResponseSpec.ok200())
                .extract().as(OwnerResponse.class);
    }
}
