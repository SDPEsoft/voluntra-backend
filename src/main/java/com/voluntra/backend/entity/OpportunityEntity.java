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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
@Table(name = "opportunity")
public class OpportunityEntity {

    // attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "opportunityId")
    private Long id;

    private String title;

    private String description;

    private String type; // one-time, long-term, ongoing

    private String location; // city and region

    private String objectives; // teaching, cleaning, buidling, etc ..

    private Date startDate;

    private Date endDate;

    // relationships

    @ManyToOne
    @JoinColumn(name = "organizationId")
    private OrganizationEntity organizationEntity;

    // @ManyToMany
    // @JoinTable(
    //     name = "volunteer_opportuntity",
    //     joinColumns = @JoinColumn(name = "opportunityId"),
    //     inverseJoinColumns = @JoinColumn(name = "volunteerId")
    // )
    // private Set<UserEntity> userEntities = new HashSet<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "opportunityEntity", cascade = CascadeType.ALL)
    private List<UserOppoEntity> userOppoEntities;
}
