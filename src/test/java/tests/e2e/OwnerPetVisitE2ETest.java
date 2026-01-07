package tests.e2e;


import base.TestBase;
import dto.owner.OwnerResponse;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import specs.OwnerSpecs;

import static assertions.OwnerAssertions.assertOwnerIsValid;
import static specs.OwnerSpecs.getOwnerById;

@Tag("e2e")
public class OwnerPetVisitE2ETest extends TestBase {

    @Test
    public void creatOwner() {
        OwnerResponse ownerResponse = OwnerSpecs.createRandomOwner();
        assertOwnerIsValid(ownerResponse);

        //getOwnerById(ownerResponse.getId());

    }
}