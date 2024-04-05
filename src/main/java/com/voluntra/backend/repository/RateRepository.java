package com.voluntra.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.voluntra.backend.entity.OpportunityEntity;
import com.voluntra.backend.entity.OrganizationEntity;
import com.voluntra.backend.entity.RateEntity;
import com.voluntra.backend.entity.UserEntity;

@Repository
public interface RateRepository extends JpaRepository<RateEntity, Long>{
    // @Query("SELECT p FROM OpportunityEntity p WHERE p.organizationEntity = :organizationEntity")
    // List<OpportunityEntity> findOpportunitiesByOrganization(@Param("organizationEntity") OrganizationEntity organizationEntity);

    @Query("SELECT p FROM RateEntity p WHERE p.userEntity = :userEntity")
    List<RateEntity> findRatesByUsers(@Param("userEntity") UserEntity userEntity);

    @Query("SELECT q FROM RateEntity q WHERE q.opportunityEntity = :opportunityEntity")
    List<RateEntity> findRatesByOppos(@Param("opportunityEntity") OpportunityEntity opportunityEntity);

    @Query("SELECT r FROM RateEntity r WHERE r.organizationEntity = :organizationEntity")
    List<RateEntity> findRatesByOrg(@Param("organizationEntity") OrganizationEntity organizationEntity);

}
