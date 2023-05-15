package com.ikub.libraryonline.project.domain.entity;

import com.ikub.libraryonline.project.domain.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;

import java.util.Arrays;


@AllArgsConstructor
public enum UserRole {

    CUSTOMER("CUSTOMER"),
    ADMIN("ADMIN");

    private String value;

    public static UserRole fromValue(String userRole){
        return Arrays.asList(UserRole.values())
                .stream().filter(r-> r.value.equals(userRole))
                .findFirst()
                .orElseThrow(
                        ()-> new ResourceNotFoundException("Role not found"));
    }

    public String getValue(){
        return value;
    }



}
