package com.shashikant.project.uber.uberApp.services.impl;

import com.shashikant.project.uber.uberApp.dtos.DriverDto;
import com.shashikant.project.uber.uberApp.dtos.SignupDto;
import com.shashikant.project.uber.uberApp.dtos.UserDto;
import com.shashikant.project.uber.uberApp.entities.User;
import com.shashikant.project.uber.uberApp.entities.enums.Role;
import com.shashikant.project.uber.uberApp.exceptions.RunTimeConflictException;
import com.shashikant.project.uber.uberApp.repositories.UserRepository;
import com.shashikant.project.uber.uberApp.services.AuthService;
import com.shashikant.project.uber.uberApp.services.RiderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private  final RiderService riderService;

    @Override
    public String login(String email, String password) {
        return "";
    }

    @Override
    @Transactional
    public UserDto signup(SignupDto signupDto) {
        User user = userRepository.findByEmail(signupDto.getEmail()).orElse(null);
        if(user != null)
              throw  new RunTimeConflictException("Cannot Signup, User already exist by email : "+ signupDto.getEmail());

        User mappedUser = modelMapper.map(signupDto, User.class);
        mappedUser.setRoles(Set.of(Role.RIDER));
        User savedUser = userRepository.save(mappedUser);

        // create user related Entities

       riderService.createNewRider(savedUser);

       // TODO create Wallet related service here

        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public DriverDto onboardNewDriver(Long userId) {
        return null;
    }
}
