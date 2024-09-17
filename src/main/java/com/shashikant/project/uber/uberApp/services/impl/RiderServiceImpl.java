package com.shashikant.project.uber.uberApp.services.impl;

import com.shashikant.project.uber.uberApp.dtos.DriverDto;
import com.shashikant.project.uber.uberApp.dtos.RideDto;
import com.shashikant.project.uber.uberApp.dtos.RideRequestDto;
import com.shashikant.project.uber.uberApp.dtos.RiderDto;
import com.shashikant.project.uber.uberApp.entities.RideRequest;
import com.shashikant.project.uber.uberApp.entities.Rider;
import com.shashikant.project.uber.uberApp.entities.User;
import com.shashikant.project.uber.uberApp.entities.enums.RideRequestStatus;
import com.shashikant.project.uber.uberApp.exceptions.ResourceNotFoundException;
import com.shashikant.project.uber.uberApp.repositories.RideRequestRepository;
import com.shashikant.project.uber.uberApp.repositories.RiderRepository;
import com.shashikant.project.uber.uberApp.services.RiderService;
import com.shashikant.project.uber.uberApp.strategies.DriverMatchingStrategy;
import com.shashikant.project.uber.uberApp.strategies.RideFareCalculationStrategy;
import com.shashikant.project.uber.uberApp.strategies.RideStrategyManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RiderServiceImpl implements RiderService {

    private final ModelMapper modelMapper;
    private final RideStrategyManager rideStrategyManager;
    private final RideRequestRepository rideRequestRepository;
    private final RiderRepository riderRepository;

    @Override
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
        Rider rider = getCurrentRider();
        RideRequest rideRequest = modelMapper.map(rideRequestDto,RideRequest.class);
        log.info(rideRequest.toString());
        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);

        Double fare = rideStrategyManager.rideFareCalculationStrategy().calculateFare(rideRequest);
        rideRequest.setFare(fare);

        RideRequest savedRideRequest = rideRequestRepository.save(rideRequest);

        rideStrategyManager.driverMatchingStrategy(rider.getRating()).findMatchingDrivers(rideRequest);

        return modelMapper.map(savedRideRequest, RideRequestDto.class);
    }

    @Override
    public RideDto cancelRide(Long rideId) {
        return null;
    }

    @Override
    public DriverDto rateDriver(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public RiderDto getMyProfile() {
        return null;
    }

    @Override
    public List<RideDto> getAllMyRides() {
        return List.of();
    }

    @Override
    public Rider createNewRider(User user) {
        Rider rider = Rider
                .builder()
                .user(user)
                .rating(0.0)
                .build();
        return riderRepository.save(rider);
    }

    @Override
    public Rider getCurrentRider() {
        // Todo : implement Spring Security
        return  riderRepository.findById(1L).orElseThrow(() -> new ResourceNotFoundException(
                "Rider not found with id: " + 1
        ));
    }
}
