package tests.owners;

import base.TestBase;
import dto.owner.OwnerResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

        assertNotEquals(owner.getFirstName(),updatedOwner.getFirstName(), "Имя должно измениться");
        assertNotEquals(owner.getLastName(), updatedOwner.getLastName(),  "Фамилия должна измениться");
        assertNotEquals(owner.getAddress(),  updatedOwner.getAddress(),   "Адрес должен обновиться");
        assertNotEquals(owner.getCity(),     updatedOwner.getCity(),      "Город должен обновиться");
        assertNotEquals(owner.getTelephone(),updatedOwner.getTelephone(), "Телефон должен обновиться");

        assertEquals(owner.getId(), updatedOwner.getId(), "ID владельца не должен измениться");
    }
}
