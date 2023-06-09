/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/9/23, 12:05 AM
 *
 */

package com.group.bestvision.yrm.test.controller.impl;

import com.group.bestvision.yrm.test.controller.ContactController;
import com.group.bestvision.yrm.test.dto.*;
import com.group.bestvision.yrm.test.mapper.ContactMapper;
import com.group.bestvision.yrm.test.service.impl.ContactServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
        contact.addLinks(Boolean.FALSE);
        return okResponse(contact);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ContactDto>> list(@RequestParam(name = "name", required = false) String name,
                                                 @RequestParam(name = "address", required = false) String address)
    {
        ContactSearchFilterDto filter = ContactSearchFilterDto.builder()
                .name(name)
                .address(address)
                .build();
        List<ContactDto> contactList = contactService.findAll(filter);
        contactList.forEach(x -> x.addLinks(Boolean.FALSE));
        return okResponse(contactList);
    }

    @Override
    @GetMapping("/page-query")
    public ResponseEntity<Page<ContactDto>> pageQuery(@RequestParam(name = "name", required = false) String name,
                                                      @RequestParam(name = "address", required = false) String address,
                                                      @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable)
    {
        ContactSearchFilterDto filter = ContactSearchFilterDto.builder()
                .name(name)
                .address(address)
                .build();
        Page<ContactDto> contactPage = contactService.findAll(filter, pageable);
        contactPage.getContent().forEach(x -> x.addLinks(Boolean.FALSE));
        return okResponse(contactPage);
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ContactDto> save(@RequestBody ContactDto contact)
    {
        ContactDto newContact = contactService.save(contact);
        newContact.addLinks(Boolean.FALSE);
        return createdResponse(newContact);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ContactDto> update(@RequestBody ContactDto contact, @PathVariable("id") long id)
    {
        ContactDto upContact = contactService.update(contact, id);
        upContact.addLinks(Boolean.FALSE);
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
    @GetMapping(value = "/{id}/addresses", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddressDto> getAddress(@PathVariable("id") long id)
    {
        Optional<List<AddressDto>> address = contactService.getAddressById(id);
        return address.isPresent() ? okResponse(address.get()) : noContentResponse();
    }

    @Override
    @GetMapping(value = "/{id}/phones", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PhoneDto>> getPhones(@PathVariable("id") long id)
    {
        Optional<List<PhoneDto>> phones = contactService.getPhonesById(id);
        return phones.isPresent() ? okResponse(phones.get()) : noContentResponse();
    }

    @Override
    @GetMapping(value = "/in_range_age/{min}/{max}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ContactDto>> getInRangeAge(@PathVariable("min") int min, @PathVariable("max") int mimaxn)
    {
        List<ContactDto> contactList = contactService.findInAgeRange(min, mimaxn);
        contactList.forEach(x -> x.addLinks(Boolean.FALSE));
        return okResponse(contactList);
    }
}
