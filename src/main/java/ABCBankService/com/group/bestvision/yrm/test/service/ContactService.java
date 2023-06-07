package ABCBankService.com.group.bestvision.yrm.test.service;

import ABCBankService.com.group.bestvision.yrm.test.dto.ContactDto;
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
}
