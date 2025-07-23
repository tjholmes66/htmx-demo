package com.tomholmes.product.htmx.demo.dto;

import com.tomholmes.product.htmx.demo.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class ContactDTO implements Serializable {

    private Long contactId;
    private UserDTO user;
    private String prefix;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private CompanyDTO company;
    private Long enteredBy;
    private LocalDateTime enteredDate;
    private Long editedBy;
    private LocalDateTime editedDate;
    private LocalDate birthDate;

}
