package com.ikub.libraryonline.project.domain.entity;

import com.ikub.libraryonline.project.domain.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;

import java.util.Arrays;
@AllArgsConstructor
public enum BookStatus {

    OUT_STOCK("OUT_OF_STOCK"),
    SOLD("SOLD"),
    IN_STOCK("IN_STOCK");

    private String value;

    public static BookStatus fromValue(String value){
        return Arrays.asList(BookStatus.values())
                .stream().filter(r-> r.value.equals(value))
                .findFirst()
                .orElseThrow(
                        ()-> new ResourceNotFoundException("Status not found"));
    }

    public String getValue(){
        return value;
    }


}
