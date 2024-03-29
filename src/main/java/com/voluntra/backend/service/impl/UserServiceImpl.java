package com.voluntra.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voluntra.backend.dto.UserPwdDto;
import com.voluntra.backend.entity.UserEntity;
import com.voluntra.backend.repository.UserRepository;
import com.voluntra.backend.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

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
    
}
