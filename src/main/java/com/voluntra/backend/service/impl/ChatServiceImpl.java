package com.voluntra.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voluntra.backend.dto.ChatDto;
import com.voluntra.backend.entity.ChatEntity;
import com.voluntra.backend.entity.OrganizationEntity;
import com.voluntra.backend.entity.UserEntity;
import com.voluntra.backend.repository.ChatRepository;
import com.voluntra.backend.repository.OrganizationRepository;
import com.voluntra.backend.repository.UserRepository;
import com.voluntra.backend.service.ChatService;

@Service
public class ChatServiceImpl implements ChatService{

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public ChatEntity createChat(ChatDto chatDto) {
        OrganizationEntity organizationEntity = organizationRepository.findById(chatDto.getOrganizationId()).orElse(null);
        UserEntity userEntity = userRepository.findById(chatDto.getVolunteerId()).orElse(null);
        if (organizationEntity!=null && userEntity!=null) {
            ChatEntity chatEntity = new ChatEntity();
            chatEntity.setMessage(chatDto.getMessage());
            chatEntity.setOrganizationEntity(organizationEntity);
            chatEntity.setVolunteerEntity(userEntity);
            return chatRepository.save(chatEntity);
        } else {
            return null;
        }
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
