package ABCBankService.com.group.bestvision.yrm.test.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Schema(name = "Phone")
public class PhoneDto
{
    private long serialVersionUID;

    @Schema(name = "id", description = "Id")
    @JsonProperty("id")
    private Long id;

    @Schema(name = "version", description = "Version")
    @JsonProperty("version")
    private Long version;

    @Schema(name = "number", description = "Number")
    @JsonProperty("number")
    @Size(max = 12)
    private String number;
}
