package com.backend.fullstack.controller;

import com.backend.fullstack.dto.AnnouncementDto;
import com.backend.fullstack.service.AnnouncementService;
import com.backend.fullstack.service.impl.AnnouncementServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/announcement")
public class AnnouncementController {
    private AnnouncementService announcementService;

    public AnnouncementController(AnnouncementService announcementService){
        this.announcementService=announcementService;
    }

    @PostMapping
    public ResponseEntity<AnnouncementDto> createAnnouncement(@RequestBody AnnouncementDto announcementDto){
        AnnouncementDto savedAnnouncement = announcementService.createAnnouncement(announcementDto);
        return new ResponseEntity<>(savedAnnouncement, HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<AnnouncementDto>> getAllAnnouncement(){
       List<AnnouncementDto> announcement= announcementService.getAllAnnouncement();
       return ResponseEntity.ok(announcement);
    }

    @GetMapping("{id}")
    public ResponseEntity<AnnouncementDto> getAnnouncementByID(@PathVariable("id") Long announcementID){
        AnnouncementDto announcementDto = announcementService.getAnnouncement(announcementID);
        return ResponseEntity.ok(announcementDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAnnouncement(@PathVariable("id")long announcementID){
        announcementService.deleteAnnouncement(announcementID);
        return ResponseEntity.ok("Volunteer deleted successfully");
    }

}
