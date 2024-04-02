package com.backend.fullstack.mapper;

import com.backend.fullstack.dto.AnnouncementDto;
import com.backend.fullstack.dto.VolunteerDto;
import com.backend.fullstack.entity.Announcement;

public class AnnouncementMapper {
    public static AnnouncementDto mapToAnnouncementDto(Announcement announcement) {
        return new AnnouncementDto(
                announcement.getAnnouncement_id(),
                announcement.getMessage(),
                announcement.getDate(),
                announcement.getVolunteer_id()
        );




    }

    public static Announcement mapToAnnouncement(AnnouncementDto announcementDto){
        return new Announcement(
                announcementDto.getAnnouncement_id(),
                announcementDto.getMessage(),
                announcementDto.getDate(),
                announcementDto.getVolunteer()
        );
    }
}
