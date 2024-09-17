package com.shashikant.project.uber.uberApp.services;

import com.shashikant.project.uber.uberApp.dtos.DriverDto;
import com.shashikant.project.uber.uberApp.dtos.RideDto;
import com.shashikant.project.uber.uberApp.dtos.RideRequestDto;
import com.shashikant.project.uber.uberApp.dtos.RiderDto;
import com.shashikant.project.uber.uberApp.entities.Rider;
import com.shashikant.project.uber.uberApp.entities.User;

import java.util.List;

public interface RiderService {

    RideRequestDto requestRide(RideRequestDto rideRequestDto);

    RideDto cancelRide(Long rideId);

    DriverDto rateDriver(Long rideId , Integer rating);

    RiderDto getMyProfile();

    List<RideDto> getAllMyRides();

    Rider createNewRider(User user);

    Rider getCurrentRider();
}
