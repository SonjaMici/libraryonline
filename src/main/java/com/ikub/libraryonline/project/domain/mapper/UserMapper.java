package com.ikub.libraryonline.project.domain.mapper;

import com.ikub.libraryonline.project.domain.dto.user.UserDTO;
import com.ikub.libraryonline.project.domain.dto.user.UserUpdateDTO;
import com.ikub.libraryonline.project.domain.entity.User;

public class UserMapper {
    public static UserDTO toDto(User u){
        return UserDTO.builder()
                .id(u.getId())
                .firstname(u.getFirstname())
                .lastname(u.getLastname())
                .email(u.getEmail())
                .phoneNumber(u.getPhoneNumber())
                .build();
    }

    public static User toEntity(UserDTO u){
        return User.builder()
                .id(u.getId())
                .firstname(u.getFirstname())
                .lastname(u.getLastname())
                .email(u.getEmail())
                .phoneNumber(u.getPhoneNumber())
                .build();
    }

    public static UserUpdateDTO toUpdateDto (User u){
        return UserUpdateDTO.builder()
                .id(u.getId())
                .firstname(u.getFirstname())
                .lastname(u.getLastname())
                .email(u.getEmail())
                .phoneNumber(u.getPhoneNumber())
                .build();
    }

    public static User toUpdateEntity (User u, UserUpdateDTO updateDTO){
        u.setFirstname(updateDTO.getFirstname());
        u.setLastname(updateDTO.getLastname());
        u.setEmail(updateDTO.getEmail());
        u.setPhoneNumber(updateDTO.getPhoneNumber());
        return u;
    }

}
