package com.voluntra.backend.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDto {
    private Date dob;
    private String phoneno;
    private String address;
    private String interests;
    private String abilities;
    private String talents;
    private String profilelink;
}
