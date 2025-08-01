package com.tomholmes.product.htmx.demo.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

/**
 * The persistent class for the Positions database table.
 * 
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
@Entity
@Table(name = "contacts_phone")
public class ContactPhoneEntity implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contacts_phone_id")
    private Long phoneId;

    // bi-directional many-to-one association to ContactEntity
    @ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "contact_id")
private ContactEntity contact;

    // bi-directional many-to-one association to ContactEntity
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "phone_type_id")
    private PhoneTypeEntity phoneType;

    @Column(name = "phone")
    private String phone;

    @Column(name = "entered_date")
    private LocalDateTime enteredDate;

}
