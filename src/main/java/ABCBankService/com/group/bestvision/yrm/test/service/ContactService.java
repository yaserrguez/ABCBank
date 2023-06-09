/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/8/23, 11:44 PM
 *
 */

package ABCBankService.com.group.bestvision.yrm.test.service;

import ABCBankService.com.group.bestvision.yrm.test.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ContactService
{
    ContactDto findById(long id);

    List<ContactDto> findAll(ContactSearchFilterDto filter);

    Page<ContactDto> findAll(ContactSearchFilterDto filter, Pageable pageable);
    ContactDto save(ContactDto dto);
    ContactDto update(ContactDto entity, long id);
    void deleteById(long id);

    Optional<PhotoDto> getPhotoById(long id);

    Optional<List<AddressDto>> getAddressById(long id);

    Optional<List<PhoneDto>> getPhonesById(long id);

    List<ContactDto> findInAgeRange(int minAge, int maxAge);
}
