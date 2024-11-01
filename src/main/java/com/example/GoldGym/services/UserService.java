package com.example.GoldGym.services;

import com.example.GoldGym.dto.UserDto;
import com.example.GoldGym.models.User;

import java.util.List;

public interface UserService {
    //Specify CRUD Operations
    UserDto createUser(UserDto userDto);
    UserDto getUserById(int id);
    List <UserDto> getAllUsers();
    UserDto updateUserById(int id, UserDto userDto);
    String deleteUserById(int id);
}
