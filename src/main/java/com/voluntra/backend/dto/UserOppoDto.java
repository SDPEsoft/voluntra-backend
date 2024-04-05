package com.voluntra.backend.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserOppoDto {
    private Long id;
    private String name;
    private String contact;
    private String qualification;
    private LocalDateTime time;
    private Long volunteerId;
    private Long opportunityId;
}
