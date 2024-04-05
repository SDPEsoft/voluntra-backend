package com.voluntra.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.voluntra.backend.entity.OpportunityEntity;
import com.voluntra.backend.entity.OrganizationEntity;

@Repository
public interface OpportunityRepository extends JpaRepository<OpportunityEntity, Long>{
    @Query("SELECT p FROM OpportunityEntity p WHERE p.organizationEntity = :organizationEntity")
    List<OpportunityEntity> findOpportunitiesByOrganization(@Param("organizationEntity") OrganizationEntity organizationEntity);
}
