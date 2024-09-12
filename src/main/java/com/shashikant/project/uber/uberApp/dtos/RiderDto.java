package com.shashikant.project.uber.uberApp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RiderDto {

    private UserDto user;
    private Double rating;
}
