package com.backend.fullstack.service;

import com.backend.fullstack.dto.AnnouncementDto;
import com.backend.fullstack.dto.VolunteerDto;

import java.util.List;

public interface AnnouncementService {

    AnnouncementDto createAnnouncement(AnnouncementDto announcementDto);
    AnnouncementDto getAnnouncement(long announcementID);
    void deleteAnnouncement(long announcementId);

    List<AnnouncementDto> getAllAnnouncement();

    AnnouncementDto updateAnnouncement(long announcementId, AnnouncementDto updatedAnnouncement);



}
