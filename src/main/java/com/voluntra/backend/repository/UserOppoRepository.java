package com.voluntra.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.voluntra.backend.entity.OpportunityEntity;
import com.voluntra.backend.entity.UserEntity;
import com.voluntra.backend.entity.UserOppoEntity;

@Repository
public interface UserOppoRepository extends JpaRepository<UserOppoEntity, Long>{
    // @Query("SELECT p FROM OpportunityEntity p WHERE p.organizationEntity = :organizationEntity")
    // List<OpportunityEntity> findOpportunitiesByOrganization(@Param("organizationEntity") OrganizationEntity organizationEntity);

    @Query("SELECT p FROM UserOppoEntity p WHERE p.opportunityEntity = :opportunityEntity")
    List<UserOppoEntity> findUserOpposByOppos(@Param("opportunityEntity") OpportunityEntity opportunityEntity);

    @Query("SELECT q FROM UserOppoEntity q WHERE q.userEntity = :userEntity")
    List<UserOppoEntity> findUserOpposByUsers(@Param("userEntity") UserEntity userEntity);
}
