package com.voluntra.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.voluntra.backend.dto.LoginDto;
import com.voluntra.backend.entity.AdminEntity;
import com.voluntra.backend.repository.AdminRepository;
import com.voluntra.backend.security.jwt.JwtUtils;
import com.voluntra.backend.service.AdminService;

@RestController
@CrossOrigin(origins = "*")
public class AdminAuthController {

    @Autowired
    AdminService adminService;

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/auth/admin/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtils.generateJwtToken(authentication);
        return ResponseEntity.ok().body(token);
    }

    @PostMapping("/auth/admin/register")
    public ResponseEntity<?> register(@RequestBody AdminEntity adminEntity){
        if (adminRepository.existsByUsername(adminEntity.getUsername())) {
            return ResponseEntity.badRequest().body("Username is already in use");
        }
        if (adminRepository.existsByEmail(adminEntity.getEmail())) {
            return ResponseEntity.badRequest().body("This email is being used");
        }
        AdminEntity newAdmin = new AdminEntity();
        newAdmin.setUsername(adminEntity.getUsername());
        newAdmin.setEmail(adminEntity.getEmail());
        newAdmin.setPassword(adminEntity.getPassword());
        return ResponseEntity.ok(adminService.createAdmin(newAdmin));
    }
    
}
