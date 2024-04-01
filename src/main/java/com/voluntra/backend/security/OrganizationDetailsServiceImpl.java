package com.voluntra.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.voluntra.backend.entity.OrganizationEntity;
import com.voluntra.backend.repository.OrganizationRepository;

@Service
public class OrganizationDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        OrganizationEntity organizationEntity = organizationRepository.findByUsername(username).orElse(null);

        if (organizationEntity == null) {
            throw new UsernameNotFoundException("User is not found with the username");
        }

        return org.springframework.security.core.userdetails.User.builder()
                .username(organizationEntity.getUsername())
                .password(organizationEntity.getPassword())
                .build();
    }
}
