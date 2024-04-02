package com.backend.fullstack.service.impl;

import com.backend.fullstack.dto.AnnouncementDto;
import com.backend.fullstack.entity.Announcement;
import com.backend.fullstack.mapper.AnnouncementMapper;
import com.backend.fullstack.repository.AnnouncementRepository;
import com.backend.fullstack.service.AnnouncementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return null;
    }

    @Override
    public void deleteAnnouncement(long announcementId) {

    }

    @Override
    public List<AnnouncementDto> getAllAnnouncement() {
        return null;
    }

    @Override
    public AnnouncementDto updateAnnouncement(long announcementId, AnnouncementDto updatedAnnouncement) {
        return null;
    }
}
