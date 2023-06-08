/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/7/23, 11:47 PM
 *
 */

package ABCBankService.com.group.bestvision.yrm.test.controller.impl;

import ABCBankService.com.group.bestvision.yrm.test.controller.ContactController;
import ABCBankService.com.group.bestvision.yrm.test.dto.AddressDto;
import ABCBankService.com.group.bestvision.yrm.test.dto.ContactDto;
import ABCBankService.com.group.bestvision.yrm.test.dto.PhoneDto;
import ABCBankService.com.group.bestvision.yrm.test.dto.PhotoDto;
import ABCBankService.com.group.bestvision.yrm.test.mapper.ContactMapper;
import ABCBankService.com.group.bestvision.yrm.test.service.impl.ContactServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/contacts")
@RestController
public class ContactControllerImpl extends BaseController implements ContactController
{
    private final ContactServiceImpl contactService;
    private final ContactMapper contactMapper;

    public ContactControllerImpl(ContactServiceImpl contactService, ContactMapper contactMapper)
    {
        this.contactService = contactService;
        this.contactMapper = contactMapper;
    }

    @Override
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContactDto> findById(@PathVariable("id") long id)
    {
        ContactDto contact = contactService.findById(id);
        return okResponse(contact);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ContactDto>> list()
    {
        List<ContactDto> contactList = contactService.findAll();
        return okResponse(contactList);
    }

    @Override
    @GetMapping("/page-query")
    public ResponseEntity<Page<ContactDto>> pageQuery(Pageable pageable)
    {
        Page<ContactDto> contactPage = contactService.findAll(pageable);
        return okResponse(contactPage);
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ContactDto> save(@RequestBody ContactDto contact)
    {
        ContactDto newContact = contactService.save(contact);
        return createdResponse(newContact);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ContactDto> update(@RequestBody ContactDto contact, @PathVariable("id") long id)
    {
        ContactDto upContact = contactService.update(contact, id);
        return okResponse(upContact);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id)
    {
        contactService.deleteById(id);
    }

    @Override
    @GetMapping(value = "/{id}/photo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PhotoDto> getPhoto(@PathVariable("id") long id)
    {
        Optional<PhotoDto> photo = contactService.getPhotoById(id);
        return photo.isPresent() ? okResponse(photo.get()) : noContentResponse();
    }

    @Override
    @GetMapping(value = "/{id}/address", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddressDto> getAddress(@PathVariable("id") long id)
    {
        Optional<AddressDto> address = contactService.getAddressById(id);
        return address.isPresent() ? okResponse(address.get()) : noContentResponse();
    }

    @Override
    @GetMapping(value = "/{id}/phones", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PhoneDto>> getPhones(@PathVariable("id") long id)
    {
        Optional<List<PhoneDto>> phones = contactService.getPhonesById(id);
        return phones.isPresent() ? okResponse(phones.get()) : noContentResponse();
    }
}
