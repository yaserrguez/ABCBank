/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/9/23, 12:05 AM
 *
 */

package com.group.bestvision.yrm.test.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Schema(name = "ContactSearchFilter")
public class ContactSearchFilterDto implements Serializable
{
    private static final long serialVersionUID = 7470391610399516675L;

    @Schema(name = "name", description = "Name")
    @JsonProperty("name")
    @Size(max = 50)
    private String name;

    @Schema(name = "address", description = "Address")
    @JsonProperty("address")
    @Size(max = 50)
    private String address;
}
