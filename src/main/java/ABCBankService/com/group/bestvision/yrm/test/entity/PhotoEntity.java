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
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "ID", nullable = false, updatable = false, columnDefinition = "number(19)")
    private Long id;

    @Column(name = "PHOTO", columnDefinition = "blob", length = 4000)
    private byte[] photo;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true )
    @MapsId
    @JoinColumn ( name = "contact_id" )
    private ContactEntity contact;

}
