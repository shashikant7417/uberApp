package com.shashikant.project.uber.uberApp.strategies.impl;

import com.shashikant.project.uber.uberApp.dtos.RideRequestDto;
import com.shashikant.project.uber.uberApp.entities.RideRequest;
import com.shashikant.project.uber.uberApp.services.DistanceService;
import com.shashikant.project.uber.uberApp.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideFareDefaultFareCalculationStrategy implements RideFareCalculationStrategy {

    private final DistanceService distanceService;

    @Override
    public double calculateFare(RideRequest rideRequest) {
        double distance = distanceService.calculateDistance(rideRequest.getPickupLocation(), rideRequest.getDropOfLocation());
        return distance* RIDE_FARE_MULTIPLIER;
    }
}
