package com.tomholmes.product.htmx.demo.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class LoginDTO implements Serializable
{
    private String username;
    private String password;
}
