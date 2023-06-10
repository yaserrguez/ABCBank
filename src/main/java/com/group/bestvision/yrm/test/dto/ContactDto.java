/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/9/23, 9:03 PM
 *
 */

package com.group.bestvision.yrm.test.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.group.bestvision.yrm.test.controller.data.impl.ContactControllerImpl;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

//@Data
@Getter
@Setter
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Schema(name = "Contact")
public class ContactDto extends EntityModel<ContactDto> implements Serializable
{
    private static final long serialVersionUID = -5505972669439664181L;

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
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Timestamp dateOfBirth;

    @Schema(name = "phones", description = "Phones")
    @JsonProperty("phones")
//    private Set<PhoneDto> phones = new HashSet<>();
    private List<PhoneDto> phones = new ArrayList<>();

//    @Schema(name = "address", description = "Address")
//    @JsonProperty("address")
//    private AddressDto address;

    @Schema(name = "addresses", description = "Addresses")
    @JsonProperty("addresses")
    private List<AddressDto> addresses = new ArrayList<>();

    @Schema(name = "photo", description = "Photo")
    @JsonProperty("photo")
    private PhotoDto photo;

    public void addLinks(Boolean replaceInfo)
    {
        Link link = WebMvcLinkBuilder.linkTo(methodOn(ContactControllerImpl.class).findById(this.getId()))
                .withSelfRel();
        this.add(link);

        Link link2 = WebMvcLinkBuilder.linkTo(methodOn(ContactControllerImpl.class).getAddress(this.getId()))
                .withRel("addresses");
        this.add(link2);

        Link link3 = WebMvcLinkBuilder.linkTo(methodOn(ContactControllerImpl.class).getPhoto(this.getId()))
                .withRel("photo");
        this.add(link3);

        Link link4 = WebMvcLinkBuilder.linkTo(methodOn(ContactControllerImpl.class).getPhones(this.getId()))
                .withRel("phones");
        this.add(link4);

        if (replaceInfo)
        {
            this.setAddresses(null);
            this.setPhoto(null);
            this.setPhones(null);
        }
    }

    public void addLinks()
    {
        this.addLinks(Boolean.TRUE);
    }
}
