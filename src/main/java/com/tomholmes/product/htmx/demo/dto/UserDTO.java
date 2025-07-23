package com.tomholmes.product.htmx.demo.dto;

import com.tomholmes.product.htmx.demo.model.PositionEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class UserDTO  implements Serializable
{
    private Long userId;
    private Boolean active;
    private PositionDTO position;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String securityQuestion1;
    private String securityAnswer1;
    private String securityQuestion2;
    private String securityAnswer2;
    private LocalDate birthDate;
}
