package com.backend.fullstack.service;

import com.backend.fullstack.dto.VolunteerDto;

import java.util.List;

public interface VolunteerService {
    VolunteerDto createVolunteer(VolunteerDto volunteerDto);

    VolunteerDto getVolunteer(long employeeID);

    List<VolunteerDto> getAllVolunteers();

}
//Interface