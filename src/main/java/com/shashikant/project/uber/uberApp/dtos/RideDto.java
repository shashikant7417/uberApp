package com.shashikant.project.uber.uberApp.dtos;

import com.shashikant.project.uber.uberApp.entities.enums.PaymentMethod;
import com.shashikant.project.uber.uberApp.entities.enums.RideRequestStatus;
import com.shashikant.project.uber.uberApp.entities.enums.RideStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RideDto {

    private Long id;

    private PointDto pickupLocation;

    private PointDto dropOfLocation;

    private LocalDateTime createdTime;

    private RiderDto rider;

    private DriverDto driver;

    private PaymentMethod paymentMethod;

    private RideRequestStatus rideRequestStatus;

    private RideStatus rideStatus;

    private String otp;

    private Double fare;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
}
