package com.tomholmes.product.htmx.demo.rest;

import com.tomholmes.product.htmx.demo.model.ContactPhoneEntity;
import com.tomholmes.product.htmx.demo.service.ContactPhoneService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rest/contact/phone")
@CrossOrigin(origins = "*")
public class RestContactPhoneController
{
    
    private ContactPhoneService contactPhoneService;

    public RestContactPhoneController(ContactPhoneService contactPhoneService)
        {
            this.contactPhoneService = contactPhoneService;
        }

        @GetMapping(value = "/contactId/{contactId}", headers = "Accept=application/json")
        public @ResponseBody List<ContactPhoneEntity> getContactPhoneListByContactId(@PathVariable("contactId") long contactId)
        {
            List<ContactPhoneEntity> contactEntityList = contactPhoneService.getAllPhonesByContactId(contactId);
            return contactEntityList;
        }

        @PostMapping(value = "/create", produces = "application/json", headers = "content-type=application/json")
        public @ResponseBody ContactPhoneEntity createContactPhoneEntity(@RequestBody ContactPhoneEntity contactPhoneEntity)
        {
            System.out.println("RestContactPhoneController: createContactPhoneEntity: contactPhoneEntity=" + contactPhoneEntity);
            ContactPhoneEntity entity = contactPhoneService.createContactPhone(contactPhoneEntity);
            return entity;
        }

        @DeleteMapping(value = "/delete/{contactPhoneId}", headers = "Accept=application/json")
        public @ResponseBody void deleteContactPhoneEntity(@PathVariable("contactPhoneId") long contactPhoneId)
        {
            System.out.println("RestContactPhoneController: START: deleteContactPhoneEntity: contactPhoneId=" + contactPhoneId);
            contactPhoneService.deleteContactPhoneById(contactPhoneId);
            System.out.println("RestContactPhoneController: FINISH: deleteContactPhoneEntity:");
        }

}
