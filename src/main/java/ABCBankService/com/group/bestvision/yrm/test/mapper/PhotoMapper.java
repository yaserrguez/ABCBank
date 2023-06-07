package ABCBankService.com.group.bestvision.yrm.test.mapper;

import ABCBankService.com.group.bestvision.yrm.test.dto.PhotoDto;
import ABCBankService.com.group.bestvision.yrm.test.entity.PhotoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PhotoMapper extends EntityMapper<PhotoDto, PhotoEntity>
{}
