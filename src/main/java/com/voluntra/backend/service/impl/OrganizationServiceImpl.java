package com.voluntra.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voluntra.backend.dto.UserPwdDto;
import com.voluntra.backend.entity.OrganizationEntity;
import com.voluntra.backend.repository.OrganizationRepository;
import com.voluntra.backend.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService{

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationEntity changeUserPassword(Long id, UserPwdDto userPwdDto) {
        OrganizationEntity organizationEntity = organizationRepository.findById(id).orElse(null);
        System.out.println(userPwdDto.getPassword());
        if (organizationEntity!=null) {
            organizationEntity.setPassword(userPwdDto.getPassword());
            return organizationRepository.save(organizationEntity);
        } else {
            return null;
        }
    }

    @Override
    public OrganizationEntity createUser(OrganizationEntity organizationEntity) {
        return organizationRepository.save(organizationEntity);
    }

    @Override
    public List<OrganizationEntity> getAllUsers() {
        return organizationRepository.findAll();
    }

    @Override
    public OrganizationEntity getUserById(Long id) {
        return organizationRepository.findById(id).orElse(null);
    }
    
}
