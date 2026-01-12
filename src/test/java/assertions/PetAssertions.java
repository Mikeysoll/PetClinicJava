package assertions;

import dto.owner.OwnerResponse;
import dto.pet.PetResponse;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PetAssertions {

    public static void assertPetIsValid(PetResponse pet) {
        assertNotNull(pet.getId(), "ID питомца должен быть сгенерирован");
        assertTrue(pet.getName().length() > 1, "Имя питомца должно содержать больше 1 символа");
    }
}