/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/9/23, 12:05 AM
 *
 */

package com.group.bestvision.yrm.test.service;

import com.group.bestvision.yrm.test.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * The interface Contact service.
 */
public interface ContactService
{
    /**
     * Find by id contact dto.
     *
     * @param id the id
     * @return the contact dto
     */
    ContactDto findById(long id);

    /**
     * Find all list.
     *
     * @param filter the filter
     * @return the list
     */
    List<ContactDto> findAll(ContactSearchFilterDto filter);

    /**
     * Find all page.
     *
     * @param filter   the filter
     * @param pageable the pageable
     * @return the page
     */
    Page<ContactDto> findAll(ContactSearchFilterDto filter, Pageable pageable);

    /**
     * Save contact dto.
     *
     * @param dto the dto
     * @return the contact dto
     */
    ContactDto save(ContactDto dto);

    /**
     * Update contact dto.
     *
     * @param entity the entity
     * @param id     the id
     * @return the contact dto
     */
    ContactDto update(ContactDto entity, long id);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(long id);

    /**
     * Gets photo by id.
     *
     * @param id the id
     * @return the photo by id
     */
    Optional<PhotoDto> getPhotoById(long id);

    /**
     * Gets address by id.
     *
     * @param id the id
     * @return the address by id
     */
    Optional<List<AddressDto>> getAddressById(long id);

    /**
     * Gets phones by id.
     *
     * @param id the id
     * @return the phones by id
     */
    Optional<List<PhoneDto>> getPhonesById(long id);

    /**
     * Find in age range list.
     *
     * @param minAge the min age
     * @param maxAge the max age
     * @return the list
     */
    List<ContactDto> findInAgeRange(int minAge, int maxAge);
}
