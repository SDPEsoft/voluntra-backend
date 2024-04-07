package com.voluntra.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrgUpdateDto {
    private String address;
    private String description;
    private String type;
    private String profilelink;
}
