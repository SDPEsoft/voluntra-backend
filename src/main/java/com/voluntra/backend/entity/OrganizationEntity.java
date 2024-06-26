package com.voluntra.backend.entity;

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
@Table(name = "organization")
public class OrganizationEntity {
    
    // attributes
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "organizationId")
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String password;

    private String address;

    private String description;

    private String type; //non-profit, ...

    private String profilelink; //link to profile image

    // relationships

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "organizationEntity", cascade = CascadeType.ALL)
    private List<OpportunityEntity> opportunities;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "organizationEntity", cascade = CascadeType.ALL)
    private List<AnnouncementEntity> announcements;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "organizationEntity", cascade = CascadeType.ALL)
    private List<ChatEntity> chats;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "organizationEntity", cascade = CascadeType.ALL)
    private List<RateEntity> rateEntities;
}
