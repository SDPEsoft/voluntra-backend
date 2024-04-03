package com.backend.fullstack.mapper;

import com.backend.fullstack.dto.OrganizationDto;
import com.backend.fullstack.entity.Organization;

public class OrganizationMapper {

    public static OrganizationDto mapToOrganizationDTO(Organization organization){
        return new OrganizationDto(
                organization.getOrganization_Id(),
                organization.getOrg_Name(),
                organization.getOrg_Email(),
                organization.getOrg_Password(),
                organization.getOrg_Contact(),
                organization.getOrg_Description()

        );
    }

    public static Organization mapToOrganization(OrganizationDto organizationDto){
        return new Organization(
                organizationDto.getOrganization_Id(),
                organizationDto.getOrg_Name(),
                organizationDto.getOrg_Email(),
                organizationDto.getOrg_Password(),
                organizationDto.getOrg_Contact(),
                organizationDto.getOrg_Description()
        );
    }
}
