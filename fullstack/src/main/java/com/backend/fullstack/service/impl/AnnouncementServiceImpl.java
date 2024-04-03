package com.backend.fullstack.service.impl;

import com.backend.fullstack.dto.AnnouncementDto;
import com.backend.fullstack.entity.Announcement;
import com.backend.fullstack.entity.Organization;
import com.backend.fullstack.exception.ResourceNotFoundException;
import com.backend.fullstack.mapper.AnnouncementMapper;
import com.backend.fullstack.repository.AnnouncementRepository;
import com.backend.fullstack.service.AnnouncementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService {
    private AnnouncementRepository announcementRepository;
    @Override
    public AnnouncementDto createAnnouncement(AnnouncementDto announcementDto) {
        Announcement announcement= AnnouncementMapper.mapToAnnouncement(announcementDto);
        Announcement savedAnnouncement = announcementRepository.save(announcement);

        return AnnouncementMapper.mapToAnnouncementDto(savedAnnouncement);
    }

    @Override
    public AnnouncementDto getAnnouncement(long announcementID) {
        Announcement announcement=announcementRepository.findById(announcementID).orElseThrow(
                ()-> new ResourceNotFoundException("Announcement Not Found!.. "+announcementID)
        );
        return AnnouncementMapper.mapToAnnouncementDto(announcement);
    }

    @Override
    public void deleteAnnouncement(long announcementId) {
        Announcement savedAnnouncement =announcementRepository.findById(announcementId).orElseThrow(
                () -> new ResourceNotFoundException( " Announcement Not Found."+announcementId)
        );
        announcementRepository.deleteById(announcementId);

    }

    @Override
    public List<AnnouncementDto> getAllAnnouncement() {
        List<Announcement> announcements = announcementRepository.findAll();

        return announcements.stream().map((announcement)-> AnnouncementMapper.mapToAnnouncementDto(announcement)).collect(Collectors.toList());
    }
//Not Implemented as not mandatory
    @Override
    public AnnouncementDto updateAnnouncement(long announcementId, AnnouncementDto updatedAnnouncement) {
        return null;
    }
}
