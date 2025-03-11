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

// CREATE TABLE `position` (
// `position_id` int(11) NOT NULL IDENTITY_INCREMENT,
// `active` tinyint(1) NOT NULL DEFAULT '1',
// `code` varchar(45) NOT NULL,
// `description` varchar(45) DEFAULT NULL,
// PRIMARY KEY (`position_id`),
// UNIQUE KEY `code_unq` (`code`)
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
@Table(name = "position")
public class PositionEntity implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Long Id;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

}
