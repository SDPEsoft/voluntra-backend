package com.voluntra.backend.service;

import org.springframework.stereotype.Service;

import com.voluntra.backend.entity.ChatEntity;

@Service
public interface ChatService {
    ChatEntity createChat(ChatEntity chatEntity);
    ChatEntity getChatById(Long id);
    ChatEntity updateChat(Long id, ChatEntity chatEntity);
    ChatEntity deleteChat(Long id);
}
