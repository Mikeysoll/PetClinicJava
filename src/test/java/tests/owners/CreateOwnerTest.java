package tests.owners;

import base.TestBase;
import dto.owner.OwnerResponse;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import specs.OwnerSpecs;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreateOwnerTest extends TestBase {

    @Test
    @Tag("owner")
    public void createRandomOwner() {
        OwnerResponse owner = OwnerSpecs.createRandomOwner();

        assertNotNull(owner.getId(), "ID должен быть сгенерирован");
        assertNotNull(owner.getFirstName(), "Имя владельца должно быть заполнено");
        assertNotNull(owner.getLastName(), "Фамилия владельца должна быть заполнена");
        assertNotNull(owner.getAddress(), "Адрес должен быть заполнен");
        assertNotNull(owner.getCity(), "Город должен быть заполнен");
        assertNotNull(owner.getTelephone(), "Телефон должен быть заполнен");
    }
}
