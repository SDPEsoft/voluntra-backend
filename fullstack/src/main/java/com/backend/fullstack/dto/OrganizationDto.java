package com.backend.fullstack.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDto {
    private long organization_Id;
    private String org_Name;
    private String org_Email;
    private String org_Password;
    private int org_Contact;
    private  String org_Description;
}
