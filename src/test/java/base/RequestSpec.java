package base;

import io.restassured.specification.RequestSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.given;

public class RequestSpec {

    public static RequestSpecification baseRequestSpec() {
        return given()
                .filter(withCustomTemplates())
                .contentType("application/json")
                .accept("application/json");
    }
}