package com.voluntra.backend.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OpportunityDto {
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private Long organizationId;
}
