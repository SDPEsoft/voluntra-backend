package com.backend.fullstack.service.impl;

import com.backend.fullstack.dto.OrganizationDto;
import com.backend.fullstack.dto.VolunteerDto;
import com.backend.fullstack.entity.Organization;
import com.backend.fullstack.mapper.OrganizationMapper;
import com.backend.fullstack.repository.OrganizationRepository;
import com.backend.fullstack.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private OrganizationRepository organizationRepository;
    @Override
    public OrganizationDto createOrganization(OrganizationDto organizationDto) {
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
        Organization savedOrganization=organizationRepository.save(organization);
        return OrganizationMapper.mapToOrganizationDTO(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganization(long organizationID) {
        return null;
    }

    @Override
    public List<OrganizationDto> getAllOrganization() {
        return null;
    }

    @Override
    public void deleteOrganization(long organizationID) {

    }

    @Override
    public OrganizationDto updateOrganization(long organizationID, OrganizationDto organizationDto) {
        return null;
    }
}
