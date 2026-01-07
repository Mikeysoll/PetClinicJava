package assertions;

import dto.owner.OwnerResponse;
import dto.pet.PetResponse;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PetAssertions {

    public static void assertPetIsValid(PetResponse pet) {
        assertNotNull(pet.getId(), "ID питомца должен быть сгенерирован");
        assertNotNull(pet.getName(), "Имя питомца должно быть заполнено");
    }
}