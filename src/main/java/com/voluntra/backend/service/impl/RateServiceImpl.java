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

    @Override
    public List<RateEntity> getRatesByOppos(Long id) {
        OpportunityEntity opportunityEntity = opportunityRepository.findById(id).orElse(null);
        if (opportunityEntity!=null) {
            return rateRepository.findRatesByOppos(opportunityEntity);
        } else {
            return null;
        }
    }

    @Override
    public List<RateEntity> getRatesByUsers(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if (userEntity!=null) {
            return rateRepository.findRatesByUsers(userEntity);
        } else {
            return null;
        }
    }

    @Override
    public List<RateEntity> getRatesByOrg(Long id) {
        OrganizationEntity organizationEntity = organizationRepository.findById(id).orElse(null);
        if (organizationEntity!=null) {
            return rateRepository.findRatesByOrg(organizationEntity);
        } else {
            return null;
        }
    }

    
    
}
