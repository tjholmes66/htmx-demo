package com.tomholmes.product.htmx.demo.rest;

import com.tomholmes.product.htmx.demo.model.ContactLinkEntity;
import com.tomholmes.product.htmx.demo.service.ContactLinkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/contact/link")
@CrossOrigin(origins = "*")
public class RestContactLinkController
{
    private ContactLinkService contactLinkService;

    public RestContactLinkController(ContactLinkService contactLinkService)
        {
            this.contactLinkService = contactLinkService;
        }

        @GetMapping(value = "/contactId/{contactId}", headers = "Accept=application/json")
        public @ResponseBody List<ContactLinkEntity> getContactLinkListByContactId(@PathVariable("contactId") long contactId)
        {
            List<ContactLinkEntity> contactEntityList = contactLinkService.getAllLinksByContactId(contactId);
            return contactEntityList;
        }

        @PostMapping(value = "/create", produces = "application/json", headers = "content-type=application/json")
        public @ResponseBody ContactLinkEntity createContactLinkEntity(@RequestBody ContactLinkEntity contactLinkEntity)
        {
            System.out.println("RestContactLinkController: createContactLinkEntity: contactLinkEntity=" + contactLinkEntity);
            ContactLinkEntity entity = contactLinkService.createContactLink(contactLinkEntity);
            return entity;
        }

        @DeleteMapping(value = "/delete/{contactLinkId}", headers = "Accept=application/json")
        public @ResponseBody void deleteContactLinkEntity(@PathVariable("contactLinkId") long contactLinkId)
        {
            System.out.println("RestContactLinkController: START: deleteContactLinkEntity: contactLinkId=" + contactLinkId);
            contactLinkService.deleteContactLinkById(contactLinkId);
            System.out.println("RestContactLinkController: FINISH: deleteContactLinkEntity:");
        }
}
