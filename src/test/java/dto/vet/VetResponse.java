package dto.vet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dto.specialty.SpecialtyResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VetResponse {
    private String firstName;
    private String lastName;
    private List<SpecialtyResponse> specialties;
    private String id;
}
