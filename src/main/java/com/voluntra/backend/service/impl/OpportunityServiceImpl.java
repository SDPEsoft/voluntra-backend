package com.voluntra.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voluntra.backend.dto.OpportunityDto;
import com.voluntra.backend.entity.OpportunityEntity;
import com.voluntra.backend.entity.OrganizationEntity;
import com.voluntra.backend.repository.OpportunityRepository;
import com.voluntra.backend.repository.OrganizationRepository;
import com.voluntra.backend.service.OpportunityService;

@Service
public class OpportunityServiceImpl implements OpportunityService{

    @Autowired
    private OpportunityRepository opportunityRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public OpportunityEntity createOpportunity(OpportunityDto opportunityDto) {
        OrganizationEntity organizationEntity = organizationRepository.findById(opportunityDto.getOrganizationId()).orElse(null);
        if (organizationEntity!=null) {
            OpportunityEntity opportunityEntity = new OpportunityEntity();
            opportunityEntity.setTitle(opportunityDto.getTitle());
            opportunityEntity.setDescription(opportunityDto.getDescription());
            opportunityEntity.setStartDate(opportunityDto.getStartDate());
            opportunityEntity.setEndDate(opportunityDto.getEndDate());
            opportunityEntity.setOrganizationEntity(organizationEntity);
            return opportunityRepository.save(opportunityEntity);
        } else {
            return null;
        }
    }

    @Override
    public OpportunityEntity deleteOpportunity(Long id) {
        OpportunityEntity opportunityEntity = opportunityRepository.findById(id).orElse(null);
        if (opportunityEntity!=null) {
            opportunityRepository.delete(opportunityEntity);
            return opportunityEntity;
        } else {
            return null;
        }
    }

    @Override
    public List<OpportunityEntity> getAllOpportunities() {
        return opportunityRepository.findAll();
    }

    @Override
    public OpportunityEntity getOpportunitiesById(Long id) {
        return opportunityRepository.findById(id).orElse(null);
    }

    @Override
    public List<OpportunityEntity> getOpportunitiesByOrganization(Long id) {
        OrganizationEntity organizationEntity = organizationRepository.findById(id).orElse(null);
        if (organizationEntity!=null) {
            return opportunityRepository.findOpportunitiesByOrganization(organizationEntity);
        } else {
            return null;
        }
    }

    @Override
    public OpportunityEntity updateOpportunity(Long id, OpportunityEntity opportunityEntity) {
        OpportunityEntity existingOpportunity = opportunityRepository.findById(id).orElse(null);
        if (existingOpportunity!=null) {
            existingOpportunity.setTitle(opportunityEntity.getTitle());
            existingOpportunity.setDescription(opportunityEntity.getDescription());
            existingOpportunity.setStartDate(opportunityEntity.getStartDate());
            existingOpportunity.setEndDate(opportunityEntity.getEndDate());
            return opportunityRepository.save(existingOpportunity);
        } else {
            return null;
        }
    }
    
}
