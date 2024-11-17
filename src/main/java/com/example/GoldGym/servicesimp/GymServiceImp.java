package com.example.GoldGym.servicesimp;

import com.example.GoldGym.dto.GymDto;
import com.example.GoldGym.mapper.GymMapper;
import com.example.GoldGym.models.Gym;
import com.example.GoldGym.repositories.GymRepository;
import com.example.GoldGym.repositories.UserRepository;
import com.example.GoldGym.services.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class GymServiceImp implements GymService {
    @Autowired
    private GymRepository gymRepository;
    @Autowired
    private GymMapper gymMapper;
    @Autowired
    private UserRepository userRepository;
    @Override
    public GymDto createGym(GymDto gymDto) {
        Gym gym=gymMapper.mapToGym(gymDto);
        Gym savedGym=gymRepository.save(gym);
        return gymMapper.mapToGymDto(savedGym);
    }

    @Override
    public GymDto getGymById(int id) {
        Gym gym=gymRepository.findById(id).orElseThrow(() -> new RuntimeException(("Gym Id does not Exist")));
        return gymMapper.mapToGymDto(gym);
    }

    @Override
    public List<GymDto> getAllGyms() {
        List<Gym>  gyms= gymRepository.findAll();
        List<GymDto> gymDtos=gyms.stream().map(gymMapper::mapToGymDto).collect(Collectors.toList());

        return gymDtos;
    }

    @Override
    public List<GymDto> getgymsByUserId(int userId) {
        return List.of();
    }

    @Override
    public GymDto updateGymById(int id, GymDto gymDto) {
      Gym gym = gymRepository.
                findById(id).
                orElseThrow( () -> new RuntimeException("Gym of this ID does not exist") );

        // Step 2.
        gym.setAddress(gymDto.getAddress());
        gym.setManagerName(gymDto.getManagerName());

        // Step 3.
       Gym savedgym = gymRepository.save(gym);
        return gymMapper.mapToGymDto(savedgym);
    } @Override
    public String deleteGymById(int id) {
        if (gymRepository.existsById(id)) {
            gymRepository.deleteById(id);
            return "Successfully deleted Gym " + id;
        }
        else {
            return "No record of that ID found.";
        }
    }
}
