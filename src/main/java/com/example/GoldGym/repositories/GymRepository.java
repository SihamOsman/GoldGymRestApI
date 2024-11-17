package com.example.GoldGym.repositories;

import com.example.GoldGym.models.Gym;
import com.example.GoldGym.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GymRepository extends JpaRepository<Gym,Integer> {
    @Query(value = "SELECT * FROM gyms WHERE user_id = ?", nativeQuery = true)
    List<Gym> getByUser(int userId);
}
