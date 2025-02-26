package com.tomholmes.product.htmx.demo.model;

import java.io.Serializable;
import java.util.Date;

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

@Data
@With
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
@Entity
@Table(name = "contacts_email")
public class ContactEmailEntity implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contacts_email_id")
    private long emailId;

    // bi-directional many-to-one association to ContactEntity
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contact_id")
    private ContactEntity contact;

    // bi-directional many-to-one association to ContactEntity
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "email_type_id")
    private EmailTypeEntity emailType;

    @Column(name = "email")
    private String email;

    @Column(name = "entered_date")
    private Date enteredDate;

}
