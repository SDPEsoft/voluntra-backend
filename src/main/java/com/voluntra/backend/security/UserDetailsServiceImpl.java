package com.voluntra.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.voluntra.backend.entity.AdminEntity;
import com.voluntra.backend.entity.OrganizationEntity;
import com.voluntra.backend.entity.UserEntity;
import com.voluntra.backend.repository.AdminRepository;
import com.voluntra.backend.repository.OrganizationRepository;
import com.voluntra.backend.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserEntity userEntity = userRepository.findByUsername(username).orElse(null);
        OrganizationEntity organizationEntity = organizationRepository.findByUsername(username).orElse(null);
        AdminEntity adminEntity = adminRepository.findByUsername(username).orElse(null);

        if (userEntity != null) {
            return org.springframework.security.core.userdetails.User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .build();
        } else if (organizationEntity != null) {
            return org.springframework.security.core.userdetails.User.builder()
                .username(organizationEntity.getUsername())
                .password(organizationEntity.getPassword())
                .build();
        } else if (adminEntity != null) {
            return org.springframework.security.core.userdetails.User.builder()
                .username(adminEntity.getUsername())
                .password(adminEntity.getPassword())
                .build();
        } else {
            throw new UsernameNotFoundException("User not found with the provided username");
        }
    }

}
