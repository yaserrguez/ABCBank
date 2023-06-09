/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/9/23, 12:05 AM
 *
 */

package com.group.bestvision.yrm.test.repository;

import com.group.bestvision.yrm.test.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Long>, JpaSpecificationExecutor<ContactEntity>
{
    @Query("SELECT c FROM ContactEntity c WHERE c.dateOfBirth BETWEEN :start AND :end")
    List<ContactEntity> getInRangeDate(@Param("start") Timestamp start, @Param("end") Timestamp end);
}
