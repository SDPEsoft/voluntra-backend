package com.voluntra.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.voluntra.backend.dto.AnnouncementDto;
import com.voluntra.backend.entity.AnnouncementEntity;
import com.voluntra.backend.service.AnnouncementService;

@RestController
@CrossOrigin(origins = "*")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    @GetMapping("/announcements")
    public ResponseEntity<List<AnnouncementEntity>> getAllAnnouncements(){
        List<AnnouncementEntity> announcementEntities = announcementService.getAllAnnouncements();
        if (announcementEntities!=null) {
            return ResponseEntity.status(200).body(announcementEntities);
        } else {
            return ResponseEntity.status(400).body(null);
        }
    }

    @PostMapping("/announcements")
    public ResponseEntity<AnnouncementEntity> createAnnouncement(@RequestBody AnnouncementDto announcementDto){
        try {
            return ResponseEntity.status(200).body(announcementService.createAnnouncement(announcementDto));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/announcements/{id}")
    public ResponseEntity<AnnouncementEntity> getAnnouncementsById(@PathVariable Long id){
        AnnouncementEntity announcementEntity = announcementService.getAnnouncementsById(id);
        if (announcementEntity!=null) {
            return ResponseEntity.status(HttpStatus.OK).body(announcementEntity);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/announcements/{id}")
    public AnnouncementEntity updateAnnouncement(@PathVariable Long id, @RequestBody AnnouncementEntity announcementEntity){
        return announcementService.updateAnnouncement(id, announcementEntity);
    }

    @GetMapping("/organizations/{id}/announcements")
    public ResponseEntity<List<AnnouncementEntity>> getAnnouncementsByOrganization(@PathVariable Long id){
        return ResponseEntity.ok().body(announcementService.getAnnouncementsByOrganization(id));
    }

    @DeleteMapping("/announcements/{id}")
    public AnnouncementEntity deleteAnnouncement(@PathVariable Long id){
        return announcementService.deleteAnnouncement(id);
    }
    
}
