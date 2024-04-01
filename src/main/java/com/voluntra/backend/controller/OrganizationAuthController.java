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
import com.voluntra.backend.entity.OrganizationEntity;
import com.voluntra.backend.repository.OrganizationRepository;
import com.voluntra.backend.security.jwt.JwtUtils;
import com.voluntra.backend.service.OrganizationService;

@RestController
@CrossOrigin(origins = "*")
public class OrganizationAuthController {

    @Autowired
    OrganizationService organizationService;

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/auth/org/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtils.generateJwtToken(authentication);
        return ResponseEntity.ok().body(token);
    }

    @PostMapping("/auth/org/register")
    public ResponseEntity<?> register(@RequestBody OrganizationEntity organizationEntity){
        if (organizationRepository.existsByUsername(organizationEntity.getUsername())) {
            return ResponseEntity.badRequest().body("Username is already in use");
        }
        if (organizationRepository.existsByEmail(organizationEntity.getEmail())) {
            return ResponseEntity.badRequest().body("This email is being used");
        }
        OrganizationEntity newOrg = new OrganizationEntity();
        newOrg.setUsername(organizationEntity.getUsername());
        newOrg.setEmail(organizationEntity.getEmail());
        newOrg.setPassword(organizationEntity.getPassword());
        newOrg.setType(organizationEntity.getType());
        return ResponseEntity.ok(organizationService.createOrganization(newOrg));
    }
    
}
