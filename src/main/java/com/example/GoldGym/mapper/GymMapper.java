package com.example.GoldGym.mapper;

import com.example.GoldGym.dto.GymDto;
import com.example.GoldGym.dto.UserDto;
import com.example.GoldGym.models.Gym;
import com.example.GoldGym.models.User;
import org.springframework.stereotype.Component;

@Component
public class GymMapper {

    public Gym mapToGym(GymDto gymDto) {
        Gym gym=new Gym(
                gymDto.getId(),
                gymDto.getManagerName(),
                gymDto.getAddress()
        ) ;
        return gym;
    }
    public GymDto mapToGymDto(Gym gym) {
        GymDto gymDto=new GymDto(
                gym.getId(),
                gym.getManagerName(),
                gym.getAddress()
        ) ;
        return gymDto;
    }
}
