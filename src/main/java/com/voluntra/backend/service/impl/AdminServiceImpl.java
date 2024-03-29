package com.voluntra.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voluntra.backend.dto.UserPwdDto;
import com.voluntra.backend.entity.AdminEntity;
import com.voluntra.backend.repository.AdminRepository;
import com.voluntra.backend.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public AdminEntity changeUserPassword(Long id, UserPwdDto userPwdDto) {
        AdminEntity adminEntity = adminRepository.findById(id).orElse(null);
        System.out.println(userPwdDto.getPassword());
        if (adminEntity!=null) {
            adminEntity.setPassword(userPwdDto.getPassword());
            return adminRepository.save(adminEntity);
        } else {
            return null;
        }
    }

    @Override
    public AdminEntity createAdmin(AdminEntity adminEntity) {
        return adminRepository.save(adminEntity);
    }

    @Override
    public List<AdminEntity> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public AdminEntity getAdminById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }
    
}
