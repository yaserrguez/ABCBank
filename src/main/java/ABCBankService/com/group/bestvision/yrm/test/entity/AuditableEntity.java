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
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
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

    @CreatedBy
    @Column(name = "CREATED_BY", nullable = false, updatable = false, columnDefinition = "varchar(50)")
    private String createdBy = "-";

    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY", nullable = false, columnDefinition = "varchar(50)")
    private String lastModifiedBy;

    @Version
    @Column(name = "VERSION", columnDefinition = "number(19)")
    private Long version = 0L;

    @Column(name="ENABLED", columnDefinition = "number(19)")
    private Boolean enabled = Boolean.TRUE;
}
