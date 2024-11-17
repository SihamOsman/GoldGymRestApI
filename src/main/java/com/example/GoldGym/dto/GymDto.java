package com.example.GoldGym.dto;

import com.example.GoldGym.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class GymDto {
    private int id;
    private String address;
    private String managerName;
    private int userId;
    //private User userID;
}
