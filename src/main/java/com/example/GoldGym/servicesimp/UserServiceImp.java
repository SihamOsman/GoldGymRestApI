package com.example.GoldGym.servicesimp;

import com.example.GoldGym.dto.UserDto;
import com.example.GoldGym.mapper.UserMapper;
import com.example.GoldGym.models.User;
import com.example.GoldGym.repositories.UserRepository;
import com.example.GoldGym.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDto createUser(UserDto userDto) {
      User user =userMapper.mapToUser(userDto);
      User savedUser =userRepository.save(user);
        return userMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(int id) {
        User user = userRepository.findById(id).orElseThrow( () -> new RuntimeException( ("User ID does not Exist")));
        return userMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return null;
    }

    @Override
    public UserDto UpdateuserAddressById(int id, String address) {
        User user =userRepository.findById(id).orElseThrow( () -> new RuntimeException("User Id does not exist"));
        user.setAddress(address);
        User savedaddress =userRepository.save(user);
        return userMapper.mapToUserDto(savedaddress);
    }

    @Override
    public String deleteUserByID(int id) {
        return null;
    }
}
