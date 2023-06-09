/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/9/23, 12:05 AM
 *
 */

package com.group.bestvision.yrm.test.mapper;

import com.group.bestvision.yrm.test.dto.AddressDto;
import com.group.bestvision.yrm.test.entity.AddressEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper extends EntityMapper<AddressDto, AddressEntity>
{

}
