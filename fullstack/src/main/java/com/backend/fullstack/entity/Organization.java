package com.backend.fullstack.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long organization_Id;

    @Column(name = "org_name")
    private String org_Name;
    @Column(name = "org_email",nullable = false,unique = true)
    private String org_Email;
    @Column(name = "org_password")
    private String org_Password;
    @Column(name = "org_contact")
    private int org_Contact;
    @Column(name = "org_description")
    private  String org_Description;
}
