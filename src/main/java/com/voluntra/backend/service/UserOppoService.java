package com.voluntra.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.voluntra.backend.dto.UserOppoDto;
import com.voluntra.backend.entity.UserOppoEntity;

@Service
public interface UserOppoService {
    List<UserOppoEntity> getAllUserOppos();
    UserOppoEntity createUserOppo(UserOppoDto userOppoDto);
    List<UserOppoEntity> getUserOpposByUsers(Long id);
    List<UserOppoEntity> getUserOpposByOppos(Long id);
    UserOppoEntity getUserOpposById(Long id);
}
