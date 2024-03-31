package com.backend.fullstack.service.impl;

import com.backend.fullstack.dto.VolunteerDto;
import com.backend.fullstack.entity.Volunteer;
import com.backend.fullstack.mapper.VolunteerMapper;
import com.backend.fullstack.repository.VolunteerRepository;
import com.backend.fullstack.service.VolunteerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VolunteerServiceImpl implements VolunteerService {
    private VolunteerRepository volunteerRepository;
    @Override
    public VolunteerDto createVolunteer(VolunteerDto volunteerDto) {
        Volunteer volunteer = VolunteerMapper.mapTpVolunteer(volunteerDto);
        Volunteer savedVolunteer= volunteerRepository.save(volunteer);
        return VolunteerMapper.mapToVolunteerDto(savedVolunteer);

    }

    @Override
    public VolunteerDto getVolunteer(long employeeID) {
        return null;
    }
    //Implementation
}
