package dto.pet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dto.pettype.PetTypeResponse;
import dto.visit.VisitResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PetResponse {
    private String name;
    private String birthDate;
    private PetTypeResponse type;
    private String id;
    private String ownerId;
    private List<VisitResponse> visits;
}
