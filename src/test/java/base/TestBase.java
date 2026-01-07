package base;

import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.*;

public class TestBase {

    @BeforeAll
    static void setup() {
        baseURI = "http://localhost:9966";
        basePath = "/petclinic";
    }
}
