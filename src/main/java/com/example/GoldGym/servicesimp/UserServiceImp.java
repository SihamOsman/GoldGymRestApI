package com.example.GoldGym.servicesimp;

import com.example.GoldGym.dto.UserDto;
import com.example.GoldGym.mapper.UserMapper;
import com.example.GoldGym.models.User;
import com.example.GoldGym.repositories.UserRepository;
import com.example.GoldGym.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

        List<User> users= userRepository.findAll();
        List<UserDto> userDtos= users.stream().map(userMapper::mapToUserDto).collect(Collectors.toList());
        return userDtos;
    }


    @Override
    public UserDto updateUserById(int id, UserDto userDto) {
        /*
            1. Retrieve product by id
            2. Use setters to change the properties of user
            3. Save the user in the DB with the updated properties.
            4. Convert the entity user into a DTO object
            5. Return the DTO object to the Controller
         */

        // Step 1.
        User user = userRepository.
                findById(id).
                orElseThrow( () -> new RuntimeException("User of this ID does not exist") );

        // Step 2.
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setAddress(userDto.getAddress());

        // Step 3.
        User savedUser = userRepository.save(user);

        // Step 4 and 5
        return userMapper.mapToUserDto(savedUser);
    }

    @Override
    public String deleteUserById(int id) {
        /*
            1. Check if the object of this id exists
            2. If it does, delete it.
         */
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "Successfully deleted user " + id;
        }
        else {
            return "No record of that ID found.";
        }
    }
}
