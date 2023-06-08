/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/8/23, 1:04 PM
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
@Entity(name = "PhotoEntity")
@Table(name = "T_PHOTO")
public class PhotoEntity implements Serializable
{
    private static final long serialVersionUID = 34488883266989686L;

    @Id
    private Long id;

//    @Column(name = "PHOTO", columnDefinition = "blob", length = 4000)
//    private byte[] photo;

    @Column(name = "URL", length = 200, columnDefinition = "varchar(200)")
    private String url;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
//    @JoinColumn ( name = "CONTACT_ID" )
    private ContactEntity contact;

}
