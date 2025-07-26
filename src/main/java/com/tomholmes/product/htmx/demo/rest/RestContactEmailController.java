package com.tomholmes.product.htmx.demo.rest;

import com.tomholmes.product.htmx.demo.model.CompanyEntity;
import com.tomholmes.product.htmx.demo.model.ContactEmailEntity;
import com.tomholmes.product.htmx.demo.service.ContactEmailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/contact/email")
@CrossOrigin(origins = "*")
public class RestContactEmailController
{
    private ContactEmailService contactEmailService;

    public RestContactEmailController(ContactEmailService contactEmailService)
    {
        this.contactEmailService = contactEmailService;
    }

    @GetMapping(value = "/contactId/{contactId}", headers = "Accept=application/json")
    public @ResponseBody List<ContactEmailEntity> getContactEmailListByContactId(@PathVariable("contactId") long contactId)
    {
        List<ContactEmailEntity> contactEntityList = contactEmailService.getAllEmailsByContactId(contactId);
        return contactEntityList;
    }

    @PostMapping(value = "/create", produces = "application/json", headers = "content-type=application/json")
    public @ResponseBody ContactEmailEntity createContactEmailEntity(@RequestBody ContactEmailEntity contactEmailEntity)
    {
        System.out.println("RestContactEmailController: createContactEmailEntity: contactEmailEntity=" + contactEmailEntity);
        ContactEmailEntity entity = contactEmailService.createContactEmail(contactEmailEntity);
        return entity;
    }

    @DeleteMapping(value = "/delete/{contactEmailId}", headers = "Accept=application/json")
    public @ResponseBody void deleteContactEmailEntity(@PathVariable("contactEmailId") long contactEmailId)
    {
        System.out.println("RestContactEmailController: START: deleteContactEmailEntity: contactEmailId=" + contactEmailId);
        contactEmailService.deleteContactEmailById(contactEmailId);
        System.out.println("RestContactEmailController: FINISH: deleteContactEmailEntity:");
    }
}
