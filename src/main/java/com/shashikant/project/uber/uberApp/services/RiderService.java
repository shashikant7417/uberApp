package com.shashikant.project.uber.uberApp.services;

import com.shashikant.project.uber.uberApp.dtos.DriverDto;
import com.shashikant.project.uber.uberApp.dtos.RideDto;
import com.shashikant.project.uber.uberApp.dtos.RideRequestDto;
import com.shashikant.project.uber.uberApp.dtos.RiderDto;
import com.shashikant.project.uber.uberApp.entities.Rider;
import com.shashikant.project.uber.uberApp.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface RiderService {

    RideRequestDto requestRide(RideRequestDto rideRequestDto);

    RideDto cancelRide(Long rideId);

    DriverDto rateDriver(Long rideId , Integer rating);

    RiderDto getMyProfile();

    Page<RideDto> getAllMyRides(PageRequest pageRequest);

    Rider createNewRider(User user);

    Rider getCurrentRider();
}
