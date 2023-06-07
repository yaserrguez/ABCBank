package ABCBankService.com.group.bestvision.yrm.test.controller.impl;

import ABCBankService.com.group.bestvision.yrm.test.controller.ContactController;
import ABCBankService.com.group.bestvision.yrm.test.dto.ContactDto;
import ABCBankService.com.group.bestvision.yrm.test.mapper.ContactMapper;
import ABCBankService.com.group.bestvision.yrm.test.service.impl.ContactServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<ResponseEntity<ContactDto>> save(@RequestBody ContactDto contact)
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
}
