package com.backend.fullstack.controller;

import com.backend.fullstack.dto.VolunteerDto;
import com.backend.fullstack.service.VolunteerService;
import com.backend.fullstack.service.impl.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/volunteer")
public class VolunteerController {
    private VolunteerService volunteerService;
    @Autowired
    private EmailSenderService emailSenderService;

    // Constructor injection to initialize VolunteerService
    public VolunteerController(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }

    //Build rest api
    @PostMapping //Post Method
    public ResponseEntity<VolunteerDto> createVolunteer(@RequestBody VolunteerDto volunteerDto){
        VolunteerDto savedVolunteer= volunteerService.createVolunteer(volunteerDto);

        emailSenderService.sendEmail("sai.charan73@yahoo.com","subject","Volunteer added");


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

    //Build Update Employee REST API
    @PutMapping("{id}")
    public ResponseEntity<VolunteerDto> updateVolunteer(@PathVariable("id") long volunteerId,@RequestBody VolunteerDto updatedVolunteer){
        VolunteerDto volunteerDto=volunteerService.updateVolunteer(volunteerId,updatedVolunteer);
        return  ResponseEntity.ok(volunteerDto);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity<String> deleteEmployee(@PathVariable("id") long volunteerId){
        volunteerService.deleteVolunteer(volunteerId);
        return ResponseEntity.ok("Volunteer deleted successfully!.");
    }
}
