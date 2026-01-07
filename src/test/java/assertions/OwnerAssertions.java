package assertions;

import dto.owner.OwnerResponse;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OwnerAssertions {

    public static void assertOwnerIsValid(OwnerResponse owner) {
        assertNotNull(owner, "Owner не должен быть null");

        assertNotNull(owner.getId(), "ID должен быть сгенерирован");
        assertNotNull(owner.getFirstName(), "Имя владельца должно быть заполнено");
        assertNotNull(owner.getLastName(), "Фамилия владельца должна быть заполнена");
        assertNotNull(owner.getAddress(), "Адрес должен быть заполнен");
        assertNotNull(owner.getCity(), "Город должен быть заполнен");
        assertNotNull(owner.getTelephone(), "Телефон должен быть заполнен");
    }
}