package com.shashikant.project.uber.uberApp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.PrimitiveIterator;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RiderDto {

    private  Long id;
    private UserDto user;
    private Double rating;
}
