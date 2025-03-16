package com.tomholmes.product.htmx.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tomholmes.product.htmx.demo.model.ContactEntity;
import com.tomholmes.product.htmx.demo.service.ContactService;

@RestController
@RequestMapping("/rest/contacts")
@CrossOrigin(origins = "*")
public class RestContactController
{
    private ContactService contactService;

    public RestContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping(value = "", headers = "Accept=application/json")
    public List<ContactEntity> getContactList1()
    {
        List<ContactEntity> contactEntityList = contactService.getAllContacts();
        return contactEntityList;
    }

    @GetMapping(value = "/", headers = "Accept=application/json")
    public @ResponseBody List<ContactEntity> getContactList2()
    {
        List<ContactEntity> contactEntityList = contactService.getAllContacts();
        return contactEntityList;
    }

    @GetMapping(value = "/contactId/{contactId}", headers = "Accept=application/json")
    public @ResponseBody ContactEntity getContactById(@PathVariable("contactId") long contactId)
    {
        ContactEntity contactEntity = contactService.getContactById(contactId);
        System.out.println("ContactController: retrieveContact: contactEntity=" + contactEntity);
        return contactEntity;
    }

    @GetMapping(value = "/userId/{userId}", headers = "Accept=application/json")
    public @ResponseBody List<ContactEntity> getContactsByUserId(@PathVariable("userId") long userId)
    {
        List<ContactEntity> contactEntityList = contactService.getContactsByUserId(userId);
        return contactEntityList;
    }

    @PostMapping(value = "/create", produces = "application/json", headers = "content-type=application/json")
    public @ResponseBody ContactEntity createContact(@RequestBody ContactEntity contact)
    {
        System.out.println("ContactController: createContact: contact=" + contact);
        ContactEntity contactEntity = contactService.add(contact);
        return contactEntity;
    }

    @PutMapping(value = "/update", produces = "application/json", headers = "content-type=application/json")
    public @ResponseBody ContactEntity updateContact(@RequestBody ContactEntity contact)
    {
        System.out.println("ContactController: START: updateContact: contact=" + contact);
        ContactEntity contactEntity = contactService.update(contact);
        System.out.println("ContactController: FINISH: updateContact: contactEntity=" + contactEntity);
        return contactEntity;
    }

    @DeleteMapping(value = "/delete/{contactId}",  headers = "Accept=application/json")
    public @ResponseBody void deleteContact(@PathVariable("contactId") long contactId)
    {
        System.out.println("ContactController: START: deleteContact: contactId=" + contactId);
        contactService.remove(contactId);
        System.out.println("ContactController: FINISH: deleteContact:");
    }

}
