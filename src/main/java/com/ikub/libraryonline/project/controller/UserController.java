package com.ikub.libraryonline.project.controller;

import com.ikub.libraryonline.project.domain.dto.user.UserDTO;
import com.ikub.libraryonline.project.domain.dto.user.UserUpdateDTO;
import com.ikub.libraryonline.project.domain.mapper.UserMapper;
import com.ikub.libraryonline.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PutMapping("/{id}")
    public ResponseEntity<UserUpdateDTO> updateUser (@PathVariable Integer id, @RequestBody UserUpdateDTO updateDTO){
        return ResponseEntity.ok(userService.updateUser(id,updateDTO));
    }
    @RolesAllowed("ADMIN")
    @GetMapping("/admin/{id}")
    public ResponseEntity<UserDTO> findUser (@PathVariable Integer id){
        return ResponseEntity.ok(UserMapper.toDto(userService.findUserById(id)));
    }

    @RolesAllowed("ADMIN")
    @GetMapping
    public ResponseEntity<List<UserDTO>> findUsers(){
        return ResponseEntity.ok(userService.findUsers());
    }


    @RolesAllowed("ADMIN")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
