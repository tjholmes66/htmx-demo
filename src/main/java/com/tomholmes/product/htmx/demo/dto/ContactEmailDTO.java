package com.tomholmes.product.htmx.demo.dto;

import com.tomholmes.product.htmx.demo.model.ContactEntity;
import com.tomholmes.product.htmx.demo.model.EmailTypeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class ContactEmailDTO
{
    private Long emailId;
    private ContactEntity contact;
    private EmailTypeEntity emailType;
    private String email;
    private LocalDateTime enteredDate;
}
