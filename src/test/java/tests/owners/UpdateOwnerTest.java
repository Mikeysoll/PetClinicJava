package tests.owners;

import base.TestBase;
import dto.owner.OwnerResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static specs.OwnerSpecs.createRandomOwner;
import static specs.OwnerSpecs.updateOwner;

public class UpdateOwnerTest extends TestBase {

    @Test
    @Tag("owner")
    @DisplayName("Обновление данных о владельце")
    public void updateOwnerTest(){
        OwnerResponse owner = createRandomOwner();
        OwnerResponse updatedOwner = updateOwner(owner.getId());
        assertNotEquals(owner.getFirstName(), updatedOwner.getFirstName());

    }
}
