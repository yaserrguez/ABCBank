/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/7/23, 9:18 PM
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

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Schema(name = "Photo")
public class PhotoDto implements Serializable
{

    private static final long serialVersionUID = 3650904968645630810L;

    @Schema(name = "id", description = "Id")
    @JsonProperty("id")
    private Long id;

    @Schema(name = "version", description = "Version")
    @JsonProperty("version")
    private Long version;

    @Schema(name = "photo", description = "Photo")
    @JsonProperty("photo")
    private byte[] photo;
}
