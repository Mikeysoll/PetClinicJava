package base;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.*;

public class TestBase {

    @BeforeAll
    static void setup() {
        String baseUrl = System.getProperty("baseUrl", "http://localhost:9966");
        RestAssured.baseURI = baseUrl;
        RestAssured.basePath = "/petclinic/";
    }
}
