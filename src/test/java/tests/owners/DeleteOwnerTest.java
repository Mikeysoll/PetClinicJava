package tests.owners;

import base.TestBase;
import dto.owner.OwnerResponse;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import specs.OwnerSpecs;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DeleteOwnerTest extends TestBase {

    @Test
    @Tag("owner")
    public void deleteOwner() {
        OwnerResponse owner = OwnerSpecs.createRandomOwner();

        assertNotNull(owner.getId());
        assertNotNull(owner.getFirstName());
        assertNotNull(owner.getLastName());
        assertNotNull(owner.getAddress());
        assertNotNull(owner.getCity());
        assertNotNull(owner.getTelephone());

        OwnerSpecs.deleteOwner(owner.getId());
    }
}
