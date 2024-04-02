package com.backend.fullstack.controller;

import com.backend.fullstack.dto.AnnouncementDto;
import com.backend.fullstack.service.AnnouncementService;
import com.backend.fullstack.service.impl.AnnouncementServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
