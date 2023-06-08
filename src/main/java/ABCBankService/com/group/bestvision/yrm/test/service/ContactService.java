/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/7/23, 11:47 PM
 *
 */

package ABCBankService.com.group.bestvision.yrm.test.service;

import ABCBankService.com.group.bestvision.yrm.test.dto.AddressDto;
import ABCBankService.com.group.bestvision.yrm.test.dto.ContactDto;
import ABCBankService.com.group.bestvision.yrm.test.dto.PhoneDto;
import ABCBankService.com.group.bestvision.yrm.test.dto.PhotoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ContactService
{
    ContactDto findById(long id);

    List<ContactDto> findAll();

    Page<ContactDto> findAll(Pageable pageable);
    ContactDto save(ContactDto dto);
    ContactDto update(ContactDto entity, long id);
    void deleteById(long id);

    Optional<PhotoDto> getPhotoById(long id);

    Optional<AddressDto> getAddressById(long id);

    Optional<List<PhoneDto>> getPhonesById(long id);
}
