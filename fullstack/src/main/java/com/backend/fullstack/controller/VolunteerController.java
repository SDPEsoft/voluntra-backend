package com.backend.fullstack.controller;

import com.backend.fullstack.dto.VolunteerDto;
import com.backend.fullstack.service.VolunteerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/volunteer")
public class VolunteerController {
    private VolunteerService volunteerService;

    // Constructor injection to initialize VolunteerService
    public VolunteerController(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }

    //Build rest api
    @PostMapping //Post Method
    public ResponseEntity<VolunteerDto> createVolunteer(@RequestBody VolunteerDto volunteerDto){
        VolunteerDto savedVolunteer= volunteerService.createVolunteer(volunteerDto);
        return new ResponseEntity<>(savedVolunteer, HttpStatus.CREATED);
    }
}
