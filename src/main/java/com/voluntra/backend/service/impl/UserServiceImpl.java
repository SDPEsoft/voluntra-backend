package com.voluntra.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.voluntra.backend.dto.UserPwdDto;
import com.voluntra.backend.entity.UserEntity;
import com.voluntra.backend.repository.UserRepository;
import com.voluntra.backend.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public UserEntity changeUserPassword(Long id, UserPwdDto userPwdDto) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        System.out.println(userPwdDto.getPassword());
        if (userEntity!=null) {
            userEntity.setPassword(userPwdDto.getPassword());
            return userRepository.save(userEntity);
        } else {
            return null;
        }
    }

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Voluntra | Registration Successful");
        message.setTo(userEntity.getEmail());
        message.setFrom("tech1234music@gmail.com");
        message.setText("Hello "+userEntity.getUsername()+". Your Registration is Successful with Voluntra ! Have a nice day !!");
        javaMailSender.send(message);
        return userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserEntity updateUser(Long id, UserEntity userEntity) {
        UserEntity existingUser = userRepository.findById(id).orElse(null);
        if (existingUser!=null) {
            existingUser.setAddress(userEntity.getAddress());
            existingUser.setDob(userEntity.getDob());
            existingUser.setPhoneno(userEntity.getPhoneno());
            existingUser.setInterests(userEntity.getInterests());
            existingUser.setAbilities(userEntity.getAbilities());
            existingUser.setTalents(userEntity.getTalents());
            existingUser.setProfilelink(userEntity.getProfilelink());
            return userRepository.save(existingUser);
        } else {
            return null;
        }
    }
    
}
