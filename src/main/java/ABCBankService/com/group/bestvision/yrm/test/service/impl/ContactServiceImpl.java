/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/8/23, 3:03 PM
 *
 */

package ABCBankService.com.group.bestvision.yrm.test.service.impl;

import ABCBankService.com.group.bestvision.yrm.test.dto.*;
import ABCBankService.com.group.bestvision.yrm.test.entity.ContactEntity;
import ABCBankService.com.group.bestvision.yrm.test.exception.ResourceNotFoundException;
import ABCBankService.com.group.bestvision.yrm.test.mapper.AddressMapper;
import ABCBankService.com.group.bestvision.yrm.test.mapper.ContactMapper;
import ABCBankService.com.group.bestvision.yrm.test.mapper.PhoneMapper;
import ABCBankService.com.group.bestvision.yrm.test.mapper.PhotoMapper;
import ABCBankService.com.group.bestvision.yrm.test.repository.ContactRepository;
import ABCBankService.com.group.bestvision.yrm.test.service.ContactService;
import ABCBankService.com.group.bestvision.yrm.test.specification.ContactSpecification;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class ContactServiceImpl implements ContactService
{
    private final ContactRepository repository;
    private static final ContactMapper contactMapper = Mappers.getMapper(ContactMapper.class);
    private static final PhotoMapper photoMapper = Mappers.getMapper(PhotoMapper.class);
    private static final AddressMapper addressMapper = Mappers.getMapper(AddressMapper.class);
    private static final PhoneMapper phoneMapper = Mappers.getMapper(PhoneMapper.class);

    public ContactServiceImpl(ContactRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public ContactDto findById(long id)
    {
        try
        {
            ContactEntity entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(String.format("Contacto con id '%s' no encontrado", id)));

            return contactMapper.toDto(entity);
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
            throw e;
        }
    }

    public List<ContactDto> findAll(ContactSearchFilterDto filter)
    {
        try
        {
            Specification<ContactEntity> specification = ContactSpecification.searchFilterSpecification(filter);

            List<ContactEntity> entityList = (specification == null)? repository.findAll() : repository.findAll(specification);
            return contactMapper.toDto(entityList);
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
            throw e;
        }
    }

    public Page<ContactDto> findAll(ContactSearchFilterDto filter, Pageable pageable)
    {
        try
        {
            Specification<ContactEntity> specification = ContactSpecification.searchFilterSpecification(filter);

            Page<ContactEntity> entityPage = (specification == null)? repository.findAll(pageable) : repository.findAll(specification, pageable);
            List<ContactEntity> entities = entityPage.getContent();
            return new PageImpl<>(contactMapper.toDto(entities), pageable, entityPage.getTotalElements());
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
            throw e;
        }
    }

    public ContactDto save(ContactDto contactDto)
    {
        try
        {
            ContactEntity entity = contactMapper.toEntity(contactDto);
            if (entity.getPhoto() != null)
            {
                entity.getPhoto().setContact(entity);
            }
            entity.getAddresses().forEach(x -> x.setContact(entity));
            entity.getPhones().forEach(x -> x.setContact(entity));
            return contactMapper.toDto(repository.save(entity));
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public ContactDto update(ContactDto contactDto, long id)
    {
        try
        {
            if (!repository.existsById(id))
            {
                throw new ResourceNotFoundException(String.format("Contacto '%s' no encontrado", id));
            }

            return save(contactDto);
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
            throw e;
        }
    }

    public void deleteById(long id)
    {
        try
        {
            repository.deleteById(id);
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public Optional<PhotoDto> getPhotoById(long id)
    {
        try
        {
            ContactEntity contact = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Contacto con id '%s' no encontrado", id)));
            if (contact == null || contact.getPhoto() == null || contact.getPhoto().getUrl() == null)
            {
                return Optional.empty();
            }
            return Optional.of(photoMapper.toDto(contact.getPhoto()));
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public Optional<List<AddressDto>> getAddressById(long id)
    {
        try
        {
            ContactEntity contact = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Contacto con id '%s' no encontrado", id)));
            if (contact == null || contact.getAddresses() == null || contact.getAddresses().isEmpty())
            {
                return Optional.empty();
            }
            return Optional.of(addressMapper.toDto(contact.getAddresses()));
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public Optional<List<PhoneDto>> getPhonesById(long id)
    {
        try
        {
            ContactEntity contact = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Contacto con id '%s' no encontrado", id)));
            if (contact == null || contact.getPhones() == null || contact.getPhones().isEmpty())
            {
                return Optional.empty();
            }
            List<PhoneDto> phoneList = contact.getPhones().stream().map(x -> phoneMapper.toDto(x)).collect(Collectors.toList());
            return Optional.of(phoneList);
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
            throw e;
        }
    }
}
