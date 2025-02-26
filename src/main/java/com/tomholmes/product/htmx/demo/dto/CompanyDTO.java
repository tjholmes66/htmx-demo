package com.tomholmes.product.htmx.demo.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class CompanyDTO implements Serializable
{
    private long companyId;
    private boolean active;
    private String companyCode;
    private String companyName;
    private String description;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;

}