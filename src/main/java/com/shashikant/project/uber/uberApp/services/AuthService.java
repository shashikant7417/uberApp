package com.shashikant.project.uber.uberApp.services;

import com.shashikant.project.uber.uberApp.dtos.DriverDto;
import com.shashikant.project.uber.uberApp.dtos.SignupDto;
import com.shashikant.project.uber.uberApp.dtos.UserDto;

public interface AuthService {

    String login(String email, String password);

    UserDto signup(SignupDto signupDto);

    DriverDto onboardNewDriver(Long userId, String vehicleId);
}
