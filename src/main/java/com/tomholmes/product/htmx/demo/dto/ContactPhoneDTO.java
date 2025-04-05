package com.tomholmes.product.htmx.demo.dto;

import com.tomholmes.product.htmx.demo.model.ContactEntity;
import com.tomholmes.product.htmx.demo.model.PhoneTypeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class ContactPhoneDTO
{
    private Long phoneId;
    private ContactEntity contact;
    private PhoneTypeEntity phoneType;
    private String phone;
    private LocalDateTime enteredDate;
}
