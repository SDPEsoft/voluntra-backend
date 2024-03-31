package com.voluntra.backend.controller;

import java.util.List;

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

import com.voluntra.backend.dto.OpportunityDto;
import com.voluntra.backend.entity.OpportunityEntity;
import com.voluntra.backend.service.OpportunityService;

@RestController
@CrossOrigin(origins = "*")
public class OpportunityController {

    @Autowired
    private OpportunityService opportunityService;

    @GetMapping("/opportunities")
    public ResponseEntity<List<OpportunityEntity>> getAllOportunities(){
        List<OpportunityEntity> opportunityEntities = opportunityService.getAllOpportunities();
        if (opportunityEntities!=null) {
            return ResponseEntity.status(200).body(opportunityEntities);
        } else {
            return ResponseEntity.status(400).body(null);
        }
    }

    @PostMapping("/opportunities")
    public ResponseEntity<OpportunityEntity> createOpportunity(@RequestBody OpportunityDto opportunityDto){
        try {
            return ResponseEntity.status(200).body(opportunityService.createOpportunity(opportunityDto));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/opportunities/{id}")
    public ResponseEntity<OpportunityEntity> getOpportunitiesById(@PathVariable Long id){
        OpportunityEntity opportunityEntity = opportunityService.getOpportunitiesById(id);
        if (opportunityEntity!=null) {
            return ResponseEntity.status(HttpStatus.OK).body(opportunityEntity);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/opportunities/{id}")
    public OpportunityEntity updateOpportunity(@PathVariable Long id, @RequestBody OpportunityEntity opportunityEntity){
        return opportunityService.updateOpportunity((id), opportunityEntity);
    }

    @GetMapping("/organizations/{id}/opportunities")
    public ResponseEntity<List<OpportunityEntity>> getOpportunitiesByOrganization(@PathVariable Long id){
        return ResponseEntity.ok().body(opportunityService.getOpportunitiesByOrganization(id));
    }

    @DeleteMapping("/opportunities/{id}")
    public OpportunityEntity deleteOpportunity(@PathVariable Long id){
        return opportunityService.deleteOpportunity(id);
    }
    
}
