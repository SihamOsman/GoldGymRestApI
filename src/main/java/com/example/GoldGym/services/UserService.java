package com.example.GoldGym.services;

import com.example.GoldGym.dto.UserDto;
import com.example.GoldGym.models.User;

import java.util.List;

public interface UserService {
    //Specify CRUD Operations
    UserDto createUser(UserDto userDto);
    UserDto getUserById(int id);
   List <UserDto> getAllUsers();
    UserDto UpdateuserAddressById(int id ,String address ) ;
    String deleteUserByID(int id);
}
