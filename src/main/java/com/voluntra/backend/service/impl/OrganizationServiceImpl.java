package com.voluntra.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.voluntra.backend.dto.OrgUpdateDto;
import com.voluntra.backend.dto.UserPwdDto;
import com.voluntra.backend.entity.OrganizationEntity;
import com.voluntra.backend.repository.OrganizationRepository;
import com.voluntra.backend.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService{

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    JavaMailSender javaMailSender;

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
    public OrganizationEntity createOrganization(OrganizationEntity organizationEntity) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Voluntra | Registration Successful");
        message.setTo(organizationEntity.getEmail());
        message.setFrom("tech1234music@gmail.com");
        message.setText("Hello "+organizationEntity.getUsername()+". Your Organization Registration is Successful with Voluntra ! Have a nice day !!");
        javaMailSender.send(message);
        return organizationRepository.save(organizationEntity);
    }

    @Override
    public List<OrganizationEntity> getAllOrganizations() {
        return organizationRepository.findAll();
    }

    @Override
    public OrganizationEntity getOrganizationById(Long id) {
        return organizationRepository.findById(id).orElse(null);
    }

    @Override
    public OrganizationEntity updateOrganization(Long id, OrgUpdateDto orgUpdateDto) {
        OrganizationEntity existingOrg = organizationRepository.findById(id).orElse(null);
        if (existingOrg!=null) {
            existingOrg.setAddress(orgUpdateDto.getAddress());
            existingOrg.setDescription(orgUpdateDto.getDescription());
            existingOrg.setType(orgUpdateDto.getType());
            existingOrg.setProfilelink(orgUpdateDto.getProfilelink());
            return organizationRepository.save(existingOrg);
        } else {
            return null;
        }
    }
    
}
