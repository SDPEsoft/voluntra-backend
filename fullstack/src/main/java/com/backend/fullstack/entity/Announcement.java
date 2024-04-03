package com.backend.fullstack.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "announcement")
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long announcement_id;
    @Column(name = "message")
    private  String message;
    @Column(name = "date")
    private String date;

    @ManyToOne
    @JoinColumn(name = "volunteer_id")
    @JsonIgnore // This prevents Jackson from serializing the volunteer_id
    private Volunteer volunteer_id;

}
