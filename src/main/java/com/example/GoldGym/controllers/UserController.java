package com.example.GoldGym.controllers;

import com.example.GoldGym.dto.UserDto;
import com.example.GoldGym.models.User;
import com.example.GoldGym.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("/api/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<UserDto> adduser(@RequestBody UserDto userDto) {
        return new ResponseEntity<> (userService.createUser(userDto), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable int id) {
        UserDto userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> userDtos = userService.getAllUsers();
        return ResponseEntity.ok(userDtos);
    }
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUserById(@PathVariable int id, @RequestBody UserDto userDto) {
        UserDto updatedUserDto = userService.updateUserById(id, userDto);
        return ResponseEntity.ok(updatedUserDto);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable int id) {
        String response = userService.deleteUserById(id);
        return ResponseEntity.ok(response);
    }

}
