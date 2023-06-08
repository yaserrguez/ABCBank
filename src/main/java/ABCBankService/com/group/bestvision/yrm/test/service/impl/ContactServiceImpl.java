/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/7/23, 9:18 PM
 *
 */

package ABCBankService.com.group.bestvision.yrm.test.service.impl;

import ABCBankService.com.group.bestvision.yrm.test.dto.ContactDto;
import ABCBankService.com.group.bestvision.yrm.test.entity.ContactEntity;
import ABCBankService.com.group.bestvision.yrm.test.exception.ResourceNotFoundException;
import ABCBankService.com.group.bestvision.yrm.test.mapper.ContactMapper;
import ABCBankService.com.group.bestvision.yrm.test.repository.ContactRepository;
import ABCBankService.com.group.bestvision.yrm.test.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
public class ContactServiceImpl implements ContactService
{
    private final ContactRepository repository;
    private static final ContactMapper contactMapper = Mappers.getMapper(ContactMapper.class);

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

    public List<ContactDto> findAll()
    {
        try
        {
            return contactMapper.toDto(repository.findAll());
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
            throw e;
        }
    }

    public Page<ContactDto> findAll(Pageable pageable)
    {
        try
        {
            Page<ContactEntity> entityPage = repository.findAll(pageable);
            return new PageImpl<>(contactMapper.toDto(entityPage.getContent()), pageable, entityPage.getTotalElements());
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
            throw e;
        }
    }

    public Page<ContactDto> findByCondition(ContactDto contactDto, Pageable pageable)
    {
        try
        {
            Page<ContactEntity> entityPage = repository.findAll(pageable);
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

            ContactEntity newData = contactMapper.toEntity(contactDto);
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
}
