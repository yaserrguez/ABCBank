/*
 * Copyright (c) 2023.  Yaser Rodriguez
 * yaser.rguez@gmail.com
 * LastUpdate: 6/9/23, 12:05 AM
 *
 */

package com.group.bestvision.yrm.test.specification;

import com.group.bestvision.yrm.test.dto.ContactSearchFilterDto;
import com.group.bestvision.yrm.test.entity.AddressEntity;
import com.group.bestvision.yrm.test.entity.ContactEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class ContactSpecification
{
    public static Specification<ContactEntity> searchFilterSpecification(ContactSearchFilterDto filter)
    {
        if (filter == null || (filter.getName() == null && filter.getAddress() == null))
        {
            return null;
        }
        return (Specification<ContactEntity>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<Predicate>();

            if (filter.getName() != null && !filter.getName().isEmpty())
            {
                List<Predicate> predicatesName = new ArrayList<Predicate>();
                predicatesName.add(criteriaBuilder.equal(root.get("firstName"), filter.getName()));
                predicatesName.add(criteriaBuilder.equal(root.get("secondName"), filter.getName()));
                predicates.add(criteriaBuilder.or(predicatesName.toArray(new Predicate[]{})));
            }

            if (filter.getAddress() != null && !filter.getAddress().isEmpty())
            {
                List<Predicate> predicatesAddress = new ArrayList<Predicate>();
                Join<AddressEntity, ContactEntity> type = root.join("addresses");
                predicatesAddress.add(criteriaBuilder.equal(type.get("street"), filter.getAddress()));
                predicatesAddress.add(criteriaBuilder.equal(type.get("town"), filter.getAddress()));
                predicatesAddress.add(criteriaBuilder.equal(type.get("district"), filter.getAddress()));
                predicatesAddress.add(criteriaBuilder.equal(type.get("contry"), filter.getAddress()));
                predicates.add(criteriaBuilder.or(predicatesAddress.toArray(new Predicate[]{})));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
        };
    }
}
