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
@Table(name = "chat")
public class ChatEntity {
    
    // attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "chatId")
    private Long id;

    private String message;

    // relationships

    @ManyToOne
    @JoinColumn(name = "volunteerId")
    private UserEntity volunteerEntity;

    @ManyToOne
    @JoinColumn(name = "organizationId")
    private OrganizationEntity organizationEntity;
}
