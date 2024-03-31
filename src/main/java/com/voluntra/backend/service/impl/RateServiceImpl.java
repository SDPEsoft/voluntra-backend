package com.voluntra.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voluntra.backend.dto.RateDto;
import com.voluntra.backend.entity.OpportunityEntity;
import com.voluntra.backend.entity.OrganizationEntity;
import com.voluntra.backend.entity.RateEntity;
import com.voluntra.backend.entity.UserEntity;
import com.voluntra.backend.repository.OpportunityRepository;
import com.voluntra.backend.repository.OrganizationRepository;
import com.voluntra.backend.repository.RateRepository;
import com.voluntra.backend.repository.UserRepository;
import com.voluntra.backend.service.RateService;

@Service
public class RateServiceImpl implements RateService{

    @Autowired
    private RateRepository rateRepository;

    @Autowired 
    private UserRepository userRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private OpportunityRepository opportunityRepository;

    @Override
    public RateEntity addRate(RateDto rateDto) {
        UserEntity userEntity = userRepository.findById(rateDto.getVolunteerId()).orElse(null);
        OrganizationEntity organizationEntity = organizationRepository.findById(rateDto.getOrganizationId()).orElse(null);
        OpportunityEntity opportunityEntity = opportunityRepository.findById(rateDto.getOpportunityId()).orElse(null);
        if (userEntity!=null && opportunityEntity!=null) {
            RateEntity rateEntity = new RateEntity();
            rateEntity.setFeedback(rateDto.getFeedback());
            rateEntity.setRate(rateDto.getRate());
            rateEntity.setUserEntity(userEntity);
            rateEntity.setOpportunityEntity(opportunityEntity);
            rateEntity.setOrganizationEntity(organizationEntity);
            return rateRepository.save(rateEntity);
        } else {
            return null;
        }
    }

    @Override
    public List<RateEntity> getAllRates() {
        return rateRepository.findAll();
    }

    
    
}
