package com.voluntra.backend.entity;

import java.time.LocalDateTime;

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
@Table(name = "volunteer_opportunities")
public class UserOppoEntity {

    // attributes
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voloppoId")
    private Long id;

    private String name;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String abilities;

    private String talents;

    @Column(nullable = false)
    private LocalDateTime time;

    // relationships

    @ManyToOne
    @JoinColumn(name = "volunteerId")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "opportunityId")
    private OpportunityEntity opportunityEntity;

}
