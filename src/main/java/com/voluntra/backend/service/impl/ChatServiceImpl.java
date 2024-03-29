package com.voluntra.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voluntra.backend.entity.ChatEntity;
import com.voluntra.backend.repository.ChatRepository;
import com.voluntra.backend.service.ChatService;

@Service
public class ChatServiceImpl implements ChatService{

    @Autowired
    private ChatRepository chatRepository;

    @Override
    public ChatEntity createChat(ChatEntity chatEntity) {
        return chatRepository.save(chatEntity);
    }

    @Override
    public ChatEntity deleteChat(Long id) {
        ChatEntity chatEntity = chatRepository.findById(id).orElse(null);
        if (chatEntity!=null) {
            chatRepository.delete(chatEntity);
            return chatEntity;
        } else {
            return null;
        }
    }

    @Override
    public ChatEntity getChatById(Long id) {
        return chatRepository.findById(id).orElse(null);
    }

    @Override
    public ChatEntity updateChat(Long id, ChatEntity chatEntity) {
        ChatEntity existingChat = chatRepository.findById(id).orElse(null);
        if (existingChat != null) {
            existingChat.setMessage(chatEntity.getMessage());
            return chatRepository.save(existingChat);
        } else {
            return null;
        }
    }
    
}
