package com.voluntra.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.voluntra.backend.dto.UserPwdDto;
import com.voluntra.backend.entity.UserEntity;

@Service
public interface UserService {
    UserEntity createUser(UserEntity userEntity);
    UserEntity getUserById(Long id);
    List<UserEntity> getAllUsers();
    UserEntity changeUserPassword(Long id, UserPwdDto userPwdDto);
}
