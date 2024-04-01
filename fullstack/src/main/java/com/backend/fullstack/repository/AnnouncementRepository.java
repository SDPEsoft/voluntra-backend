package com.backend.fullstack.repository;

import com.backend.fullstack.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<Announcement,Long> {
}
