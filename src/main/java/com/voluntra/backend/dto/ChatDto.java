package com.voluntra.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatDto {
    private String message;
    private Long volunteerId;
    private Long organizationId;
}
