/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/7/23, 9:18 PM
 *
 */

package ABCBankService.com.group.bestvision.yrm.test.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PhoneEntity")
@Table(name = "T_PHONE")
public class PhoneEntity implements Serializable
{
    private static final long serialVersionUID = 4579363460886075036L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, updatable = false, columnDefinition = "number(19)")
    private Long id;

    @Column(name = "NUMBER", columnDefinition = "varchar(12)")
    private String number;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ContactEntity.class)
    @JoinColumn(name = "CONTACT_ID", referencedColumnName = "ID")
    private ContactEntity contact;
}
