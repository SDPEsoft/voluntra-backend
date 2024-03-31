package com.backend.fullstack.controller;

import com.backend.fullstack.dto.VolunteerDto;
import com.backend.fullstack.service.VolunteerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //Build Get Volunteer REST API
    @GetMapping("{id}")
    public  ResponseEntity<VolunteerDto> getEmployeeByID(@PathVariable("id")  Long volunteerId){
        VolunteerDto volunteerDto = volunteerService.getVolunteer(volunteerId);
        return ResponseEntity.ok(volunteerDto);
    }

    //Build Get all employees REST API
    @GetMapping
    public ResponseEntity<List<VolunteerDto>> getAllVolunteer() {
        List<VolunteerDto> volunteers = volunteerService.getAllVolunteers();
        return  ResponseEntity.ok(volunteers);
    }
}
