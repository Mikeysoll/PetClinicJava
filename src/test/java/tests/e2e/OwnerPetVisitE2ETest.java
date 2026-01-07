package tests.e2e;


import base.TestBase;
import dto.owner.OwnerResponse;
import dto.pet.PetResponse;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import specs.OwnerSpecs;
import specs.PetSpecs;

import static assertions.OwnerAssertions.assertOwnerIsValid;
import static assertions.PetAssertions.assertPetIsValid;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static specs.OwnerSpecs.getOwnerById;
import static specs.PetSpecs.getPetById;

@Tag("e2e")
public class OwnerPetVisitE2ETest extends TestBase {

    @Test
    public void creatOwner() throws Exception {
        OwnerResponse ownerResponse = OwnerSpecs.createRandomOwner();
        assertOwnerIsValid(ownerResponse);
        getOwnerById(ownerResponse.getId());

        PetResponse petResponse = PetSpecs.createRandomPet(ownerResponse.getId());
        assertPetIsValid(petResponse);

        getPetById(petResponse.getId());

    }
}