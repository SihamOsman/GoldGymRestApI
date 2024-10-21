package com.example.GoldGym.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
//DTO Data Transfer object
//A DTP is the object in Java which will be used to create an entity object to be added to the database
@Data
@AllArgsConstructor
public class UserDto {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
}
