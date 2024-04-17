package com.voluntra.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.voluntra.backend.dto.ChatDto;
import com.voluntra.backend.entity.ChatEntity;
import com.voluntra.backend.service.ChatService;

@RestController
@CrossOrigin(origins = "*")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/chats")
    public ResponseEntity<ChatEntity> createChat(@RequestBody ChatDto chat) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(chatService.createChat(chat));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/chats/{id}")
    public ResponseEntity<ChatEntity> getChatById(@PathVariable Long id) {
        ChatEntity chatEntity = chatService.getChatById(id);
        if (chatEntity != null) {
            return ResponseEntity.status(HttpStatus.OK).body(chatEntity);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/chats/{id}")
    public ResponseEntity<ChatEntity> updateChat(@PathVariable Long id, @RequestBody ChatEntity chat) {
        ChatEntity updatedChat = chatService.updateChat(id, chat);
        if (updatedChat != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedChat);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/chats/{id}")
    public ResponseEntity<String> deleteChat(@PathVariable Long id) {
        ChatEntity deletedChat = chatService.deleteChat(id);
        if (deletedChat != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Chat deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Chat not found");
        }
    }
    
}
