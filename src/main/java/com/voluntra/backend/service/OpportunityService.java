package com.voluntra.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.voluntra.backend.dto.OpportunityDto;
import com.voluntra.backend.entity.OpportunityEntity;

@Service
public interface OpportunityService {
    List<OpportunityEntity> getAllOpportunities();
    OpportunityEntity createOpportunity(OpportunityDto opportunityDto);
    OpportunityEntity getOpportunitiesById(Long id);
    OpportunityEntity updateOpportunity(Long id, OpportunityEntity opportunityEntity);
    List<OpportunityEntity> getOpportunitiesByOrganization(Long id);
    OpportunityEntity deleteOpportunity(Long id);
}
