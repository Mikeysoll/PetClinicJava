package tests.owners;

import base.TestBase;
import dto.owner.OwnerResponse;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static specs.OwnerSpecs.getAllOwners;

public class GetOwnerListTest extends TestBase {

    @Test
    @Tag("owner")
    public void getOwnerListTest() {
        OwnerResponse[] owners = getAllOwners();

        assertTrue(owners.length > 0, "Список владельцев не должен быть пустым.");
    }
}
