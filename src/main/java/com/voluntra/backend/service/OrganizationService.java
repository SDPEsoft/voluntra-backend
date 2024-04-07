package com.voluntra.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.voluntra.backend.dto.OrgUpdateDto;
import com.voluntra.backend.dto.UserPwdDto;
import com.voluntra.backend.entity.OrganizationEntity;

@Service
public interface OrganizationService {
    OrganizationEntity createOrganization(OrganizationEntity organizationEntity);
    OrganizationEntity getOrganizationById(Long id);
    List<OrganizationEntity> getAllOrganizations();
    OrganizationEntity changeUserPassword(Long id, UserPwdDto userPwdDto);
    OrganizationEntity updateOrganization(Long id, OrgUpdateDto orgUpdateDto);
}
