/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/7/23, 9:18 PM
 *
 */

package ABCBankService.com.group.bestvision.yrm.test.mapper;

import ABCBankService.com.group.bestvision.yrm.test.dto.ContactDto;
import ABCBankService.com.group.bestvision.yrm.test.entity.ContactEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper extends EntityMapper<ContactDto, ContactEntity>
{
}