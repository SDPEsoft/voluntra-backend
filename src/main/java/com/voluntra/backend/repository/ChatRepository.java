package com.voluntra.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voluntra.backend.entity.ChatEntity;

@Repository
public interface ChatRepository extends JpaRepository<ChatEntity, Long>{
    
}
