package com.backend.fullstack.dto;

import com.backend.fullstack.entity.Volunteer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnnouncementDto {

    private long announcement_id;
    private String message;
    private Date date;
    private Volunteer volunteer;
}
