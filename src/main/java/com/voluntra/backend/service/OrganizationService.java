package com.voluntra.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.voluntra.backend.dto.UserPwdDto;
import com.voluntra.backend.entity.OrganizationEntity;

@Service
public interface OrganizationService {
    OrganizationEntity createUser(OrganizationEntity organizationEntity);
    OrganizationEntity getUserById(Long id);
    List<OrganizationEntity> getAllUsers();
    OrganizationEntity changeUserPassword(Long id, UserPwdDto userPwdDto);
}
