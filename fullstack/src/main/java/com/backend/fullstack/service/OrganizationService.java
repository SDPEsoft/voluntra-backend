package com.backend.fullstack.service;

import com.backend.fullstack.dto.OrganizationDto;
import com.backend.fullstack.dto.VolunteerDto;

import java.util.List;

public interface OrganizationService {
    OrganizationDto createOrganization(OrganizationDto organizationDto);

    OrganizationDto getOrganization(long organizationID);

    List<OrganizationDto> getAllOrganization();

    void deleteOrganization(long organizationID);

    OrganizationDto updateOrganization(long organizationID,OrganizationDto organizationDto);
}
