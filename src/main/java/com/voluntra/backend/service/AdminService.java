package com.voluntra.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.voluntra.backend.dto.UserPwdDto;
import com.voluntra.backend.entity.AdminEntity;

@Service
public interface AdminService {
    AdminEntity createAdmin(AdminEntity adminEntity);
    AdminEntity getAdminById(Long id);
    List<AdminEntity> getAllAdmins();
    AdminEntity changeUserPassword(Long id, UserPwdDto userPwdDto);
}
