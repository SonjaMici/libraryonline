package com.ikub.libraryonline.project.service;

import com.ikub.libraryonline.project.domain.dto.user.UserDTO;
import com.ikub.libraryonline.project.domain.dto.user.UserUpdateDTO;
import com.ikub.libraryonline.project.domain.entity.User;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.List;

public interface UserService {
    User findUserById (Integer id);
    List<UserDTO> findUsers();
    Void deleteUser(Integer id);
    UserUpdateDTO updateUser(Integer id, UserUpdateDTO userDto);
    UserDTO registerUser (UserDTO userDTO, String userRole);
    User getUserFromToken(Jwt jwt);
















}
