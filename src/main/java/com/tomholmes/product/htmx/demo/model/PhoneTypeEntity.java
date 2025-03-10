package com.tomholmes.product.htmx.demo.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

// CREATE TABLE `phone_type` (
// `phone_type_id` int(11) NOT NULL IDENTITY_INCREMENT,
// `phone_type_description` varchar(45) NOT NULL,
// `phone_type_active` tinyint(1) NOT NULL DEFAULT '1',
// PRIMARY KEY (`phone_type_id`),
// UNIQUE KEY `phone_type_description_UNIQUE` (`phone_type_description`)
// ) ENGINE=InnoDB IDENTITY_INCREMENT=4 DEFAULT CHARSET=utf8$$

/**
 * The persistent class for the Positions database table.
 * 
 */

@Data
@With
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
@Entity
@Table(name = "phone_type")
public class PhoneTypeEntity implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_type_id")
    private long id;

    @Column(name = "phone_type_description")
    private String description;

    @Column(name = "phone_type_active")
    private Boolean active;

}
