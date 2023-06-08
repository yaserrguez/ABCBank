/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/8/23, 1:04 PM
 *
 */

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
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Schema(name = "Address")
public class AddressDto implements Serializable
{
    private static final long serialVersionUID = 2021199631145275765L;

    @Schema(name = "id", description = "Id")
    @JsonProperty("id")
    private Long id;

    @Schema(name = "street", description = "Street")
    @JsonProperty("street")
    @Size(max = 50)
    private String street;

    @Schema(name = "houseNumber", description = "House Number")
    @JsonProperty("houseNumber")
    @Size(max = 50)
    private String houseNumber;

    @Schema(name = "between1", description = "Between 1")
    @JsonProperty("between1")
    @Size(max = 50)
    private String between1;

    @Schema(name = "between2", description = "Between 2")
    @JsonProperty("between2")
    @Size(max = 50)
    private String between2;

    @Schema(name = "town", description = "Town")
    @JsonProperty("town")
    @Size(max = 50)
    private String town;

    @Schema(name = "district", description = "District")
    @JsonProperty("district")
    @Size(max = 50)
    private String district;

    @Schema(name = "state", description = "State")
    @JsonProperty("state")
    @Size(max = 50)
    private String state;

    @Schema(name = "contry", description = "Contry")
    @JsonProperty("contry")
    @Size(max = 50)
    private String contry;
}
