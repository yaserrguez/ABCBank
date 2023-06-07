package ABCBankService.com.group.bestvision.yrm.test.controller;

import ABCBankService.com.group.bestvision.yrm.test.dto.ContactDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//@Api(tags = "ContactEntity API")
public interface ContactController
{
    //@ApiOperation("Find by Id")
    ResponseEntity<ContactDto> findById(long id);

    //@ApiOperation("Find all data")
    ResponseEntity<List<ContactDto>> list();

    //@ApiOperation("Pagination request")
    ResponseEntity<Page<ContactDto>> pageQuery(Pageable pageable);

    //@ApiOperation("Add new data")
    ResponseEntity<ResponseEntity<ContactDto>> save(ContactDto contactDTO);

    //@ApiOperation("Update one data")
    ResponseEntity<ContactDto> update(ContactDto dto, long id);

    //@ApiOperation("Delete based on primary key")
    void delete(long id);
}
