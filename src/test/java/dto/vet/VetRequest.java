package dto.vet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dto.specialty.SpecialtyRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VetRequest {
    private String firstName;
    private String lastName;
    private List<SpecialtyRequest> specialties;
}
