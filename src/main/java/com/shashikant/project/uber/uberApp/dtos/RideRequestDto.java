package com.shashikant.project.uber.uberApp.dtos;

import com.shashikant.project.uber.uberApp.entities.Rider;
import com.shashikant.project.uber.uberApp.entities.enums.PaymentMethod;
import com.shashikant.project.uber.uberApp.entities.enums.RideRequestStatus;
import com.shashikant.project.uber.uberApp.entities.enums.RideStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideRequestDto {

    private Long id;

    private PointDto pickupLocation;

    private PointDto dropOfLocation;

    private LocalDateTime requestedTime;

    private PaymentMethod paymentMethod;

    private RiderDto rider;

    private Double fare;

    private RideRequestStatus rideRequestStatus;


}
