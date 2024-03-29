package com.voluntra.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.voluntra.backend.dto.UserPwdDto;
import com.voluntra.backend.entity.AdminEntity;

@Service
public interface AdminService {
    AdminEntity createUser(AdminEntity adminEntity);
    AdminEntity getUserById(Long id);
    List<AdminEntity> getAllUsers();
    AdminEntity changeUserPassword(Long id, UserPwdDto userPwdDto);
}
