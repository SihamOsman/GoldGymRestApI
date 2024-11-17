package com.example.GoldGym.mapper;

import com.example.GoldGym.dto.UserDto;
import com.example.GoldGym.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    //Convert DTo object into Entity Object
    public static User mapToUser(UserDto userDto) {
        User user=new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setAddress(userDto.getAddress());
//                userDto.getId(),
//                userDto.getFirstName(),
//                userDto.getLastName(),
//                userDto.getAddress()
//        ) ;
        return user;
    }
    public UserDto mapToUserDto(User user) {
        UserDto userDto=new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getAddress()
        ) ;
        return userDto;
    }
}
