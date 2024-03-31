package com.voluntra.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.voluntra.backend.dto.UserOppoDto;
import com.voluntra.backend.entity.UserOppoEntity;
import com.voluntra.backend.service.UserOppoService;

@RestController
@CrossOrigin(origins = "*")
public class UserOppoController {

    @Autowired
    private UserOppoService userOppoService;

    @PostMapping("/useroppos")
    public ResponseEntity<UserOppoEntity> createUserOppo(@RequestBody UserOppoDto userOppoDto){
        try {
            return ResponseEntity.status(200).body(userOppoService.createUserOppo(userOppoDto));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/useroppos")
    public ResponseEntity<List<UserOppoEntity>> getAllUserOppos(){
        List<UserOppoEntity> userOppoEntities = userOppoService.getAllUserOppos();
        if (userOppoEntities!=null) {
            return ResponseEntity.status(200).body(userOppoEntities);
        } else {
            return ResponseEntity.status(400).body(null);
        }
    }
    
}
