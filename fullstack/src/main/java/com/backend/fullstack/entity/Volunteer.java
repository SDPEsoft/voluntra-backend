package com.backend.fullstack.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//lombok automatically sets getter and setter and constructors
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "volunteer")
public class Volunteer {        //Setting the DataBase entity

    @Id  //Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Auto increment
    private long volunteerID;

    @Column(name = "full_name")
    private String name;

    @Column(name = "contact_number")
    private int contactNumber;

    @Column(name = "user_email_id",nullable = false,unique = true)  //email will be nullable and unique
    private String email;
    @Column(name = "user_password")
    private String password;


}
