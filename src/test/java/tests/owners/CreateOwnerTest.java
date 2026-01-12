package tests.owners;

import base.TestBase;
import dto.owner.OwnerResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import specs.OwnerSpecs;

import static assertions.OwnerAssertions.assertOwnerIsValid;

public class CreateOwnerTest extends TestBase {

    @Test
    @Tag("owner")
    @DisplayName("Создание случайного владельца")
    public void createRandomOwner() {
        OwnerResponse owner = OwnerSpecs.createRandomOwner();
        assertOwnerIsValid(owner);

    }
}
