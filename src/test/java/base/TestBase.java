package base;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public class TestBase {

    @BeforeAll
    static void setup() {
        baseURI = "http://localhost:9966";
        basePath = "/petclinic";
    }
}
