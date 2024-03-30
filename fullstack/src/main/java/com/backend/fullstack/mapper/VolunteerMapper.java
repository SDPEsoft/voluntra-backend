package com.backend.fullstack.mapper;

import com.backend.fullstack.dto.VolunteerDto;
import com.backend.fullstack.entity.Volunteer;

public class VolunteerMapper {
    public static VolunteerDto mapToVolunteerDto(Volunteer volunteer){
        return new VolunteerDto(
                volunteer.getVolunteerID(),
                volunteer.getName(),
                volunteer.getContactNumber(),
                volunteer.getEmail(),
                volunteer.getPassword()
        );
    }

    public static Volunteer mapTpVolunteer(VolunteerDto volunteerDto){
        return new Volunteer(
                volunteerDto.getVolunteerID(),
                volunteerDto.getName(),
                volunteerDto.getContactNumber(),
                volunteerDto.getEmail(),
                volunteerDto.getPassword()
        );
    }
}
