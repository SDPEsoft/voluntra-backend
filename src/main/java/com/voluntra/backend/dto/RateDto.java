package com.voluntra.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RateDto {
    private String feedback;
    private String rate;
    private Long volunteerId;
    private Long organizationId;
    private Long opportunityId;
}
