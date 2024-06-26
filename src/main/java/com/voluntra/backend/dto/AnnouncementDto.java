package com.voluntra.backend.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnnouncementDto {
    private String title;
    private String message;
    private Date date;
    private String description;
    private Long organizationId;
}
