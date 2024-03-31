package com.voluntra.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
@Table(name = "rate")
public class RateEntity {

    // attributes
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rateId")
    private Long id;

    private String feedback;

    private String rate; // 0-5

    // relationships

    @ManyToOne
    @JoinColumn(name = "volunteerId")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "organizationId")
    private OrganizationEntity organizationEntity;

    @ManyToOne
    @JoinColumn(name = "opportunityId")
    private OpportunityEntity opportunityEntity;

}
