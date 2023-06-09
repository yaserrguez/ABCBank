/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/9/23, 12:05 AM
 *
 */

package com.group.bestvision.yrm.test.mapper;

import com.group.bestvision.yrm.test.dto.PhoneDto;
import com.group.bestvision.yrm.test.entity.PhoneEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhoneMapper extends EntityMapper<PhoneDto, PhoneEntity>
{}
