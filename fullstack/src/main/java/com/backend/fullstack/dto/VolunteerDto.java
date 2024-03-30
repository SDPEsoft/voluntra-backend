package com.backend.fullstack.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VolunteerDto {
    private long volunteerID;
    private String name;
    private int contactNumber;
    private String email;
    private String password;
}
