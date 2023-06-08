/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/7/23, 9:18 PM
 *
 */

package ABCBankService.com.group.bestvision.yrm.test.service;

import ABCBankService.com.group.bestvision.yrm.test.dto.ContactDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContactService
{
    ContactDto findById(long id);

    List<ContactDto> findAll();

    Page<ContactDto> findAll(Pageable pageable);
    ContactDto save(ContactDto dto);
    ContactDto update(ContactDto entity, long id);
    void deleteById(long id);
}
