package ABCBankService.com.group.bestvision.yrm.test.mapper;

import ABCBankService.com.group.bestvision.yrm.test.dto.PhoneDto;
import ABCBankService.com.group.bestvision.yrm.test.entity.PhoneEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PhoneMapper extends EntityMapper<PhoneDto, PhoneEntity>
{}
