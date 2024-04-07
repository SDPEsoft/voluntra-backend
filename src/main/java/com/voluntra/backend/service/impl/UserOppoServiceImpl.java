package com.voluntra.backend.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.voluntra.backend.dto.UserOppoDto;
import com.voluntra.backend.entity.OpportunityEntity;
import com.voluntra.backend.entity.UserEntity;
import com.voluntra.backend.entity.UserOppoEntity;
import com.voluntra.backend.repository.OpportunityRepository;
import com.voluntra.backend.repository.UserOppoRepository;
import com.voluntra.backend.repository.UserRepository;
import com.voluntra.backend.service.UserOppoService;

@Service
public class UserOppoServiceImpl implements UserOppoService {

    @Autowired
    private UserOppoRepository userOppoRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OpportunityRepository opportunityRepository;

    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public UserOppoEntity createUserOppo(UserOppoDto userOppoDto) {
        UserEntity userEntity = userRepository.findById(userOppoDto.getVolunteerId()).orElse(null);
        OpportunityEntity opportunityEntity = opportunityRepository.findById(userOppoDto.getOpportunityId())
                .orElse(null);
        if (userEntity != null && opportunityEntity != null) {
            UserOppoEntity userOppoEntity = new UserOppoEntity();
            userOppoEntity.setId(userOppoDto.getId());
            userOppoEntity.setQualification(userOppoDto.getQualification());
            LocalDateTime dateTime = LocalDateTime.now();
            userOppoEntity.setTime(dateTime);
            userOppoEntity.setUserEntity(userEntity);
            userOppoEntity.setOpportunityEntity(opportunityEntity);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject("Voluntra | Opportunity Registration Success");
            message.setTo(userEntity.getEmail());
            message.setFrom("tech1234music@gmail.com");
            message.setText("Hello " + userEntity.getUsername()
                    + "! Your Registration for " + opportunityEntity.getTitle()
                    + " is Successful! Explore more opportunities with Voluntra. Get in touch with us.");
            javaMailSender.send(message);
            return userOppoRepository.save(userOppoEntity);
        } else {
            return null;
        }
    }

    @Override
    public List<UserOppoEntity> getAllUserOppos() {
        return userOppoRepository.findAll();
    }

    @Override
    public List<UserOppoEntity> getUserOpposByOppos(Long id) {
        OpportunityEntity opportunityEntity = opportunityRepository.findById(id).orElse(null);
        if (opportunityEntity != null) {
            return userOppoRepository.findUserOpposByOppos(opportunityEntity);
        } else {
            return null;
        }
    }

    @Override
    public List<UserOppoEntity> getUserOpposByUsers(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if (userEntity != null) {
            return userOppoRepository.findUserOpposByUsers(userEntity);
        } else {
            return null;
        }
    }

    @Override
    public UserOppoEntity getUserOpposById(Long id) {
        return userOppoRepository.findById(id).orElse(null);
    }

}
