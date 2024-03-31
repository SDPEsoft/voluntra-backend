package com.voluntra.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.voluntra.backend.dto.RateDto;
import com.voluntra.backend.entity.RateEntity;
import com.voluntra.backend.service.RateService;

@RestController
@CrossOrigin(origins = "*")
public class RateController {

    @Autowired
    private RateService rateService;

    @PostMapping("/rates")
    public ResponseEntity<RateEntity> addrate(@RequestBody RateDto rateDto){
        try {
            return ResponseEntity.status(200).body(rateService.addRate(rateDto));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/rates")
    public ResponseEntity<List<RateEntity>> getAllRates(){
        List<RateEntity> rateEntities = rateService.getAllRates();
        if (rateEntities!=null) {
            return ResponseEntity.status(200).body(rateEntities);
        } else {
            return ResponseEntity.status(200).body(null);
        }
    }
    
}
