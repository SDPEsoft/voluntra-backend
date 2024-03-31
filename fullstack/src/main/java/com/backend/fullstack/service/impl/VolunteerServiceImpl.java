package com.backend.fullstack.service.impl;

import com.backend.fullstack.dto.VolunteerDto;
import com.backend.fullstack.entity.Volunteer;
import com.backend.fullstack.exception.ResourceNotFoundException;
import com.backend.fullstack.mapper.VolunteerMapper;
import com.backend.fullstack.repository.VolunteerRepository;
import com.backend.fullstack.service.VolunteerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public VolunteerDto getVolunteer(long volunteerId) {
        Volunteer volunteer = volunteerRepository.findById(volunteerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Volunteer is not found with given ID"+ volunteerId));


        return  VolunteerMapper.mapToVolunteerDto(volunteer);
    }

    @Override
    public List<VolunteerDto> getAllVolunteers() {
       List<Volunteer> volunteers = volunteerRepository.findAll();
        return volunteers.stream().map((volunteer) -> VolunteerMapper.mapToVolunteerDto(volunteer))
                .collect(Collectors.toList());
    }

    @Override
    public VolunteerDto updateVolunteer(long volunteerId, VolunteerDto updatedVolunteer) {
       Volunteer volunteer= volunteerRepository.findById(volunteerId).orElseThrow(
                ()-> new ResourceNotFoundException("Volunteer is not found with given ID"+volunteerId)
        );
       volunteer.setName(updatedVolunteer.getName());
       volunteer.setContactNumber(updatedVolunteer.getContactNumber());
       volunteer.setEmail(updatedVolunteer.getEmail());
       volunteer.setPassword(updatedVolunteer.getPassword());

       Volunteer updatedVolunteerObj=volunteerRepository.save(volunteer);

        return VolunteerMapper.mapToVolunteerDto(updatedVolunteerObj);
    }

    @Override
    public void deleteVolunteer(long volunteerId) {
        Volunteer volunteer= volunteerRepository.findById(volunteerId).orElseThrow(
                ()-> new ResourceNotFoundException("Volunteer is not found with given ID"+volunteerId)
        );
        volunteerRepository.deleteById(volunteerId);

    }
    //Implementation
}
