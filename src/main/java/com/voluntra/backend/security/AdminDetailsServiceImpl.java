package com.voluntra.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.voluntra.backend.entity.AdminEntity;
import com.voluntra.backend.repository.AdminRepository;

@Service
public class AdminDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        AdminEntity adminEntity = adminRepository.findByUsername(username).orElse(null);

        if (adminEntity == null) {
            throw new UsernameNotFoundException("Admin is not found with the username");
        }

        return org.springframework.security.core.userdetails.User.builder()
                .username(adminEntity.getUsername())
                .password(adminEntity.getPassword())
                .build();
    }
}
