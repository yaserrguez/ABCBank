/*
 * Copyright (c) 2022-2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/8/23, 3:03 PM
 *
 */

package ABCBankService.com.group.bestvision.yrm.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners({AuditingEntityListener.class})
@MappedSuperclass
public class AuditableEntity implements Serializable
{
    @CreatedDate
    @Column(name = "CREATED_DATE", nullable = false, updatable = false, columnDefinition = "timestamp(6)")
    private Timestamp createdDate;

    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE", nullable = false, columnDefinition = "timestamp(6)")
    private Timestamp lastModifiedDate;

    @Version
    @Column(name = "VERSION", columnDefinition = "number(19)")
    private Long version;

    @Column(name="ENABLED", columnDefinition = "number(19)")
    private Boolean enabled = Boolean.TRUE;
}
