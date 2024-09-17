package com.shashikant.project.uber.uberApp.services.impl;

import com.shashikant.project.uber.uberApp.dtos.DriverDto;
import com.shashikant.project.uber.uberApp.dtos.RideDto;
import com.shashikant.project.uber.uberApp.dtos.RideRequestDto;
import com.shashikant.project.uber.uberApp.dtos.RiderDto;
import com.shashikant.project.uber.uberApp.entities.Driver;
import com.shashikant.project.uber.uberApp.entities.Ride;
import com.shashikant.project.uber.uberApp.entities.enums.RideStatus;
import com.shashikant.project.uber.uberApp.services.RideService;
import com.shashikant.project.uber.uberApp.services.RiderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideServiceImpl implements RideService {


    @Override
    public Ride getRideById(Long RideId) {
        return null;
    }

    @Override
    public void matchWithDrivers(RideRequestDto rideRequestDto) {

    }

    @Override
    public Ride createNewRide(RideRequestDto rideRequestDto, Driver driver) {
        return null;
    }

    @Override
    public Ride updateRideStatus(Long rideId, RideStatus rideStatus) {
        return null;
    }

    @Override
    public Page<Ride> getAllRidesOfRider(Long riderId, PageRequest pageRequest) {
        return null;
    }

    @Override
    public Page<Ride> getAllRidesOfDriver(Long driverId, PageRequest pageRequest) {
        return null;
    }
}
