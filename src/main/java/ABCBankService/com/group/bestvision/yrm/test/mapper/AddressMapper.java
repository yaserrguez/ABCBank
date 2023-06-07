package ABCBankService.com.group.bestvision.yrm.test.mapper;

import ABCBankService.com.group.bestvision.yrm.test.dto.AddressDto;
import ABCBankService.com.group.bestvision.yrm.test.entity.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper extends EntityMapper<AddressDto, AddressEntity>
{}
