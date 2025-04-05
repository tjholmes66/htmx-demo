package com.tomholmes.product.htmx.demo.dto;

import com.tomholmes.product.htmx.demo.model.ContactEntity;
import com.tomholmes.product.htmx.demo.model.LinkTypeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class ContactLinkDTO
{
    private Long linkId;
    private ContactEntity contact;
    private LinkTypeEntity linkType;
    private String link;
    private String linkDescription;
    private LocalDateTime enteredDate;
}
