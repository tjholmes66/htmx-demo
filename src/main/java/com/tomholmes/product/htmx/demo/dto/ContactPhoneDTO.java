package com.tomholmes.product.htmx.demo.dto;

import com.tomholmes.product.htmx.demo.model.ContactEntity;
import com.tomholmes.product.htmx.demo.model.PhoneTypeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class ContactPhoneDTO  implements Serializable
{
    private Long phoneId;
    private ContactDTO contact;
    private PhoneTypeDTO phoneType;
    private String phone;
    private LocalDateTime enteredDate;
}
