package com.tomholmes.product.htmx.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class ContactDataResponseDTO implements Serializable
{
    List<ContactEmailDTO> emailList;
    List<ContactPhoneDTO> phoneList;
    List<ContactLinkDTO> linkList;
}
