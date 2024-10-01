package com.shashikant.project.uber.uberApp.controllers;

import com.shashikant.project.uber.uberApp.dtos.DriverDto;
import com.shashikant.project.uber.uberApp.dtos.OnboardDriverDto;
import com.shashikant.project.uber.uberApp.dtos.SignupDto;
import com.shashikant.project.uber.uberApp.dtos.UserDto;
import com.shashikant.project.uber.uberApp.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    UserDto signUp(@RequestBody SignupDto signupDto){

        return authService.signup(signupDto);
    }

    @PostMapping("/onboardNewDriver/{userId}")
    public ResponseEntity<DriverDto> onboardNewDriver(@PathVariable Long userId, @RequestBody OnboardDriverDto onboardDriverDto){
        return new ResponseEntity<>(authService.onboardNewDriver(userId,onboardDriverDto.getVehicleId()), HttpStatus.CREATED);

    }


}
