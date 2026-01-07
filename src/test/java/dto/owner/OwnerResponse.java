package dto.owner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dto.pet.PetResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OwnerResponse {
    private Integer id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String telephone;
    private List<PetResponse> pets;

}
