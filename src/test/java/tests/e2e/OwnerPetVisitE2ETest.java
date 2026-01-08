package tests.e2e;


import base.TestBase;
import dto.owner.OwnerResponse;
import dto.pet.PetResponse;
import dto.specialty.SpecialtyResponse;
import dto.vet.VetResponse;
import dto.visit.VisitResponse;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import specs.*;

import static assertions.OwnerAssertions.assertOwnerIsValid;
import static assertions.PetAssertions.assertPetIsValid;
import static org.junit.jupiter.api.Assertions.*;
import static specs.OwnerSpecs.getOwnerById;
import static specs.PetSpecs.getPetById;

@Tag("e2e")
public class OwnerPetVisitE2ETest extends TestBase {

    @Test
    @Tag("e2e")
    public void ownerCanCreatePetAndBookVisit() throws Exception {
        // 1. Создать владельца
        OwnerResponse ownerResponse = OwnerSpecs.createRandomOwner();
        assertOwnerIsValid(ownerResponse);
        getOwnerById(ownerResponse.getId());

        // 2. Добавить питомца
        PetResponse petResponse = PetSpecs.createRandomPet(ownerResponse.getId());
        assertPetIsValid(petResponse);
        getPetById(petResponse.getId());

        // 3. Создать специализацию
        SpecialtyResponse specialty = SpecialtySpecs.createSpecialty();
        assertNotNull(specialty.getId(), "Специальность не должна быть пустой");
        assertEquals("anesthesiologist", specialty.getName(), "Специальность должно совпадать");

        // 4. Создать врача
        VetResponse vetResponse = VetSpecs.createRandomVet();
        assertNotNull(vetResponse.getId(), "Ветеринар должен сущестовать");
        assertNotNull(vetResponse.getFirstName(), "Имя врача не должно быть пустым");
        assertNotNull(vetResponse.getLastName(), "Фамилия врача не должна быть пустой");
        assertTrue(vetResponse.getSpecialties().size() > 0, "Ветеринар должен иметь специальность");


        // 5. Записать питомца на приём
        VisitResponse visitResponse = VisitSpecs.createRandomVisit(petResponse.getId(), petResponse.getOwnerId());
        assertNotNull(visitResponse.getId(), "ID приема не может быть пустым");
        assertEquals(petResponse.getId(), visitResponse.getPetId(), "Посещение должно быть для правильного питомца");
        assertNotNull(visitResponse.getDate(), "Дата приема не может быть пустой");
        assertNotNull(visitResponse.getDescription(), "Описание не может быть пустым");

        // 6. Проверить визит
        VisitResponse visit = VisitSpecs.getVisitById(visitResponse.getId());
        assertEquals(visit.getDate(), visitResponse.getDate(), "Дата приема должна совпадать");
        assertEquals(visit.getDescription(), visitResponse.getDescription(), "Описание должно совпадать");
        assertEquals(visit.getPetId(), visitResponse.getPetId(), "ID питомца должен совпадать");

    }
}