package com.backend.fullstack.service;

import com.backend.fullstack.dto.VolunteerDto;

public interface VolunteerService {
    VolunteerDto createVolunteer(VolunteerDto volunteerDto);

    VolunteerDto getVolunteer(long employeeID);
}
//Interface