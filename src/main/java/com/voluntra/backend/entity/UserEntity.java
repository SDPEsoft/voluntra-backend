package com.voluntra.backend.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
@Table(name = "volunteer")
public class UserEntity {

    // attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "volunteerId")
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String address;

    private Date dob;

    private String phoneno;

    private String password;

    private String interests;

    private String abilities;
    
    private String talents;

    private String profilelink; //link to profile image

    // relationships

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "volunteerEntity", cascade = CascadeType.ALL)
    private List<ChatEntity> chats;

    // @JsonIgnore
    // @ManyToMany(mappedBy = "userEntities")
    // private Set<OpportunityEntity> opportunityEntities = new HashSet<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<UserOppoEntity> userOppoEntities;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<RateEntity> rateEntities;

}
