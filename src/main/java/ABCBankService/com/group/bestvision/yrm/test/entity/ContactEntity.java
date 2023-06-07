package ABCBankService.com.group.bestvision.yrm.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

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
    private LocalDateTime dateOfBirth;

    @OneToMany(mappedBy = "contact", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhoneEntity> phones = new ArrayList<>();

    @OneToOne(mappedBy = "contact", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AddressEntity addressEntity;

    @OneToOne(mappedBy = "contact", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PhotoEntity photoEntity;

}
