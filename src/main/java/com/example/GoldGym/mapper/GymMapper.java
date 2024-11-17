package com.example.GoldGym.mapper;

import com.example.GoldGym.dto.GymDto;
import com.example.GoldGym.dto.UserDto;
import com.example.GoldGym.models.Gym;
import com.example.GoldGym.models.User;
import com.example.GoldGym.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GymMapper {
    // Convert DTO to JPA
//    public Gym mapToGym(GymDto gymDto) {
//        Gym gym=new Gym(
//                gymDto.getId(),
//                gymDto.getAddress(),
//                gymDto.getManagerName(),
//                gymDto.getUserID()
//
//
//        ) ;
//        return gym;
//    }
    // Convert JPA to DTO
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    public Gym mapToGym(GymDto gymDto) {
        User userFromDB = UserMapper.mapToUser(userService.getUserById(gymDto.getId()));

        return new Gym(
                gymDto.getId(),
                gymDto.getAddress(),
                gymDto.getManagerName(),
                userFromDB
        );
    }
    public GymDto mapToGymDto(Gym gym) {
        return new GymDto(
                gym.getId(),
                gym.getAddress(),
                gym.getManagerName(),
                gym.getUserId().getId()

        ) ;
    }
}
