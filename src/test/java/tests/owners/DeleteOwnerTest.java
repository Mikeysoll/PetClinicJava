package tests.owners;

import base.RequestSpec;
import base.TestBase;
import dto.owner.OwnerResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import specs.OwnerSpecs;

import static assertions.OwnerAssertions.assertOwnerIsValid;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DeleteOwnerTest extends TestBase {

    @Test
    @Tag("owner")
    @DisplayName("Удаление владельца")
    public void deleteOwner() {
        OwnerResponse owner = OwnerSpecs.createRandomOwner();
        assertOwnerIsValid(owner);
        OwnerSpecs.deleteOwner(owner.getId());


        given()
                .spec(RequestSpec.baseRequestSpec())
                .get("api/owners/"+owner.getId())
                .then()
                .statusCode(404);
    }
}
