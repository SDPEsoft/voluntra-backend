package com.voluntra.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.voluntra.backend.entity.AnnouncementEntity;
import com.voluntra.backend.entity.OrganizationEntity;

@Repository
public interface AnnouncementRepository extends JpaRepository<AnnouncementEntity, Long>{
    @Query("SELECT q FROM AnnouncementEntity q WHERE q.organizationEntity = :organizationEntity")
    List<AnnouncementEntity> findAnnouncementsByOrganization(@Param("organizationEntity") OrganizationEntity organizationEntity);
}
