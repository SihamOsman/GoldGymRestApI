package com.example.GoldGym.services;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.GoldGym.dto.GymDto;
import com.example.GoldGym.models.Gym;

import java.util.List;

public interface GymService {
    GymDto createGym(GymDto gymDto);
    GymDto getGymById(int id);
    List<GymDto> getAllGyms();
    GymDto updateGymById(int id, GymDto gymDto);
    String deleteGymById(int id);
}
