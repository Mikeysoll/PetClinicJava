package dto.pet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dto.pettype.PetTypeRequestWithId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PetRequest {
    private String name;
    private String birthDate;
    private PetTypeRequestWithId type;
}