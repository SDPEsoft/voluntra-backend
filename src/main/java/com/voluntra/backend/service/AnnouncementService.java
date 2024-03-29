package com.voluntra.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.voluntra.backend.dto.AnnouncementDto;
import com.voluntra.backend.entity.AnnouncementEntity;

@Service
public interface AnnouncementService {
    List<AnnouncementEntity> getAllAnnouncements();
    AnnouncementEntity createAnnouncement(AnnouncementDto announcementDto);
    AnnouncementEntity getAnnouncementsById(Long id);
    AnnouncementEntity updateAnnouncement(Long id, AnnouncementEntity announcementEntity);
    List<AnnouncementEntity> getAnnouncementsByOrganization(Long id);
    AnnouncementEntity deleteAnnouncement(Long id);
}
