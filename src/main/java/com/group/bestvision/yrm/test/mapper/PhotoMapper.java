/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/9/23, 12:05 AM
 *
 */

package com.group.bestvision.yrm.test.mapper;

import com.group.bestvision.yrm.test.dto.PhotoDto;
import com.group.bestvision.yrm.test.entity.PhotoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhotoMapper extends EntityMapper<PhotoDto, PhotoEntity>
{}
