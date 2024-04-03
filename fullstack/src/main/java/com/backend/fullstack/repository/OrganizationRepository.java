package com.backend.fullstack.repository;

import com.backend.fullstack.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization,Long> {
}
