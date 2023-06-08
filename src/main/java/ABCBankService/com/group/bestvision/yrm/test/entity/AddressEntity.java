/*
 * Copyright (c) 2022-2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/7/23, 11:47 PM
 *
 */

package ABCBankService.com.group.bestvision.yrm.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "AddressEntity")
@Table(name = "T_ADDRESS")
public class AddressEntity implements Serializable
{
    private static final long serialVersionUID = -7256231143878909960L;

    @Id
    private Long id;

    @Size(max = 50, message = "'street' no válido (entre 2 y 50 caracteres)")
    @Column(name = "STREET", length = 50, columnDefinition = "varchar(50)")
    private String street;

    @Size(max = 50, message = "'houseNumber' no válido (hasta 50 caracteres)")
    @Column(name = "HOUSE_NUMBER", length = 50, columnDefinition = "varchar(50)")
    private String houseNumber;

    @Size(max = 50, message = "'between1' no válido (entre 2 y 50 caracteres)")
    @Column(name = "BETWEEN1", length = 50, columnDefinition = "varchar(50)")
    private String between1;

    @Size(max = 50, message = "'between2' no válido (entre 2 y 50 caracteres)")
    @Column(name = "BETWEEN2", length = 50, columnDefinition = "varchar(50)")
    private String between2;

    @Size(max = 50, message = "'town' no válido (entre 2 y 50 caracteres)")
    @Column(name = "TOWN", length = 50, columnDefinition = "varchar(50)")
    private String town;

    @Size(max = 50, message = "'district' no válido (entre 2 y 50 caracteres)")
    @Column(name = "DISTRICT", length = 50, columnDefinition = "varchar(50)")
    private String district;

    @Size(max = 50, message = "'state' no válido (entre 2 y 50 caracteres)")
    @Column(name = "STATE", length = 50, columnDefinition = "varchar(50)")
    private String state;

    @Size(max = 50, message = "'contry' no válido (entre 2 y 50 caracteres)")
    @Column(name = "CONTRY", length = 50, columnDefinition = "varchar(50)")
    private String contry;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    //@JoinColumn ( name = "CONTACT_ID" )
    private ContactEntity contact;

}
