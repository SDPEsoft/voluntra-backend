package com.voluntra.backend.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voluntra.backend.dto.AnnouncementDto;
import com.voluntra.backend.entity.AnnouncementEntity;
import com.voluntra.backend.entity.OrganizationEntity;
import com.voluntra.backend.repository.AnnouncementRepository;
import com.voluntra.backend.repository.OrganizationRepository;
import com.voluntra.backend.service.AnnouncementService;

@Service
public class AnnouncementServiceImpl implements AnnouncementService{

    @Autowired
    private AnnouncementRepository announcementRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public AnnouncementEntity createAnnouncement(AnnouncementDto announcementDto) {
        OrganizationEntity organizationEntity = organizationRepository.findById(announcementDto.getOrganizationId()).orElse(null);
        if (organizationEntity!=null) {
            AnnouncementEntity announcementEntity = new AnnouncementEntity();
            announcementEntity.setTitle(announcementDto.getTitle());
            announcementEntity.setMessage(announcementDto.getMessage());
            announcementEntity.setDescription(announcementDto.getDescription());
            LocalDateTime dateTime = LocalDateTime.now();
            announcementEntity.setDate(dateTime);
            announcementEntity.setOrganizationEntity(organizationEntity);
            return announcementRepository.save(announcementEntity);
        } else {
            return null;
        }
    }

    @Override
    public AnnouncementEntity deleteAnnouncement(Long id) {
        AnnouncementEntity announcementEntity = announcementRepository.findById(id).orElse(null);
        if (announcementEntity!=null) {
            announcementRepository.delete(announcementEntity);
            return announcementEntity;
        } else {
            return null;
        }
    }

    @Override
    public List<AnnouncementEntity> getAllAnnouncements() {
        return announcementRepository.findAll();
    }

    @Override
    public AnnouncementEntity getAnnouncementsById(Long id) {
        return announcementRepository.findById(id).orElse(null);
    }

    @Override
    public List<AnnouncementEntity> getAnnouncementsByOrganization(Long id) {
        OrganizationEntity organizationEntity = organizationRepository.findById(id).orElse(null);
        if (organizationEntity!=null) {
            return announcementRepository.findAnnouncementsByOrganization(organizationEntity);
        } else {
            return null;
        }
    }

    @Override
    public AnnouncementEntity updateAnnouncement(Long id, AnnouncementEntity announcementEntity) {
        AnnouncementEntity existingAnnouncement = announcementRepository.findById(id).orElse(null);
        if (existingAnnouncement!=null) {
            existingAnnouncement.setMessage(announcementEntity.getMessage());
            existingAnnouncement.setDate(announcementEntity.getDate());
            return announcementRepository.save(existingAnnouncement);
        } else {
            return null;
        }
    }
    
}
