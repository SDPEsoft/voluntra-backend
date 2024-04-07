package com.voluntra.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.voluntra.backend.dto.OrgUpdateDto;
import com.voluntra.backend.dto.UserPwdDto;
import com.voluntra.backend.entity.OrganizationEntity;
import com.voluntra.backend.service.OrganizationService;

@RestController
@CrossOrigin(origins = "*")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @GetMapping("/organizations")
    public List<OrganizationEntity> getAllOrganizations(){
        return organizationService.getAllOrganizations();
    }

    @PostMapping("/organizations")
    public OrganizationEntity createOrganization(@RequestBody OrganizationEntity organizationEntity){
        return organizationService.createOrganization(organizationEntity);
    }

    @GetMapping("/organizations/{id}")
    public OrganizationEntity getOrganizationById(@PathVariable Long id){
        return organizationService.getOrganizationById(id);
    }

    @PutMapping("/organizations/{id}/change-password")
    public ResponseEntity<OrganizationEntity> changeUserPassword(@PathVariable Long id, @RequestBody UserPwdDto userPwdDto){
        return ResponseEntity.ok().body(organizationService.changeUserPassword(id, userPwdDto));
    }

    @PutMapping("/organizations/{id}")
    public ResponseEntity<OrganizationEntity> updateOrganization(@PathVariable Long id, @RequestBody OrgUpdateDto orgUpdateDto){
        return ResponseEntity.ok().body(organizationService.updateOrganization(id, orgUpdateDto));
    }
    
}
