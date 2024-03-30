package com.voluntra.backend.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
@Table(name = "admin")
public class AdminEntity {

    // attributes
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String password;

    // relationships

    // @JsonIgnore
    // @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminEntity", cascade = CascadeType.ALL)
    // private List<UserEntity> volunteers;

    // @JsonIgnore
    // @OneToMany(fetch = FetchType.LAZY, mappedBy = "adminEntity", cascade = CascadeType.ALL)
    // private List<OrganizationEntity> organizations;
}
