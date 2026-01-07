package tests.e2e;


import dto.owner.OwnerResponse;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import specs.OwnerSpecs;

import static assertions.OwnerAssertions.assertOwnerIsValid;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Tag("e2e")
public class OwnerPetVisitE2ETest {

    @Test
    public void creatOwner() {
        OwnerResponse ownerResponse = OwnerSpecs.createRandomOwner();
        assertOwnerIsValid(ownerResponse);

    }
}