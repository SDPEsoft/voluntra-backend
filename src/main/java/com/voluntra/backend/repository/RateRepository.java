package com.voluntra.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voluntra.backend.entity.RateEntity;

@Repository
public interface RateRepository extends JpaRepository<RateEntity, Long>{
    
}
