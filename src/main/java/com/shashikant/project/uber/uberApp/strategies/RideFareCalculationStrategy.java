package com.shashikant.project.uber.uberApp.strategies;

import com.shashikant.project.uber.uberApp.dtos.RideRequestDto;

public interface RideFareCalculationStrategy {

    double calculateFare(RideRequestDto rideRequestDto);
}
