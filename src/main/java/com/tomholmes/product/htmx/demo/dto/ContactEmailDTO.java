package com.tomholmes.product.htmx.demo.dto;

import com.tomholmes.product.htmx.demo.model.ContactEntity;
import com.tomholmes.product.htmx.demo.model.EmailTypeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class ContactEmailDTO implements Serializable
{
    private Long emailId;
    private ContactDTO contact;
    private EmailTypeDTO emailType;
    private String email;
    private LocalDateTime enteredDate;
}
