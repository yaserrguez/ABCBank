/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/9/23, 12:05 AM
 *
 */

package com.group.bestvision.yrm.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ContactEntity")
@Table(name = "T_CONTACT")
public class ContactEntity extends AuditableEntity implements Serializable
{
    private static final long serialVersionUID = 7532897479015483575L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, updatable = false, columnDefinition = "number(19)")
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false, columnDefinition = "varchar(50)")
    private String firstName;

    @Column(name = "SECOND_NAME", columnDefinition = "varchar(50)")
    private String secondName;

    @Column (name = "DATE_OF_BIRTH", nullable = false)
    private Timestamp dateOfBirth;

    @OneToMany(mappedBy = "contact", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhoneEntity> phones = new ArrayList<>();

//    @OneToOne(mappedBy = "contact", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
//    private AddressEntity address;

    @OneToMany(mappedBy = "contact", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AddressEntity> addresses = new ArrayList<>();

    @OneToOne(mappedBy = "contact", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private PhotoEntity photo;

}
