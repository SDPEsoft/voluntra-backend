package com.voluntra.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.voluntra.backend.dto.UserPwdDto;
import com.voluntra.backend.entity.AdminEntity;
import com.voluntra.backend.service.AdminService;

@RestController
@CrossOrigin(origins = "*")
public class AdminController {
    
    @Autowired
    private AdminService adminService;

    @GetMapping("/admins")
    public List<AdminEntity> getAllAdmins(){
        return adminService.getAllAdmins();
    }

    @PostMapping("/admins")
    public AdminEntity createAdmin(@RequestBody AdminEntity adminEntity){
        return adminService.createAdmin(adminEntity);
    }

    @GetMapping("/admins/{id}")
    public AdminEntity getAdminById(@PathVariable Long id){
        return adminService.getAdminById(id);
    }

    @PutMapping("/admins/{id}/change-password")
    public ResponseEntity<AdminEntity> changeUserPassword(@PathVariable Long id, @RequestBody UserPwdDto userPwdDto){
        return ResponseEntity.ok().body(adminService.changeUserPassword(null, userPwdDto));
    }

}
