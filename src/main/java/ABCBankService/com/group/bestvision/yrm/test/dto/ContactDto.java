package ABCBankService.com.group.bestvision.yrm.test.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Schema(name = "Contact")
public class ContactDto
{
    private long serialVersionUID;

    @Schema(name = "id", description = "Id")
    @JsonProperty("id")
    private Long id;

    @Schema(name = "version", description = "Version")
    @JsonProperty("version")
    private Long version;

    @Schema(name = "firstName", description = "First Name")
    @JsonProperty("firstName")
    @Size(max = 50)
    private String firstName;

    @Schema(name = "secondName", description = "Second Name")
    @JsonProperty("secondName")
    @Size(max = 50)
    private String secondName;

    @Schema(name = "dateOfBirth", description = "Date Of Birth")
    @JsonProperty("dateOfBirth")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateOfBirth;

    @Schema(name = "phones", description = "Phones")
    @JsonProperty("phones")
//    private Set<PhoneDto> phones = new HashSet<>();
    private List<PhoneDto> phones = new ArrayList<>();

    @Schema(name = "address", description = "Address")
    @JsonProperty("address")
    private AddressDto address;

    @Schema(name = "photo", description = "Photo")
    @JsonProperty("photo")
    private PhotoDto photo;
}
