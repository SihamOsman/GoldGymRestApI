package com.example.GoldGym.controllers;

import com.example.GoldGym.dto.UserDto;
import com.example.GoldGym.models.User;
import com.example.GoldGym.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<UserDto> getProductById(@PathVariable int id) {
        UserDto userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

//    @PutMapping("{id}/address")
//    public ResponseEntity<UserDto> updateUserId(@PathVariable int id, @RequestBody Map<String, Double> request) {
//        String up = request.get("Address");
//        UserDto productDto = userService.updatedUserId(id, updatedPrice);
//        return ResponseEntity.ok(productDto);
//    }
}
