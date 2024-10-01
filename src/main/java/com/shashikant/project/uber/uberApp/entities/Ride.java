package com.shashikant.project.uber.uberApp.entities;

import com.shashikant.project.uber.uberApp.entities.enums.PaymentMethod;
import com.shashikant.project.uber.uberApp.entities.enums.RideRequestStatus;
import com.shashikant.project.uber.uberApp.entities.enums.RideStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(indexes = {
        @Index(name ="idx_ride_rider", columnList = "rider_id"),
        @Index(name ="idx_ride__driver", columnList = "driver_id")
})
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "Geometry(Point, 4326)")
    private Point pickupLocation;

    @Column(columnDefinition = "Geometry(Point, 4326)")
    private Point dropOfLocation;

    @CreationTimestamp
    private LocalDateTime createdTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Rider rider;

    @ManyToOne(fetch = FetchType.LAZY)
    private Driver driver;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private RideRequestStatus rideRequestStatus;

    @Enumerated(EnumType.STRING)
    private RideStatus rideStatus;

    private String otp;
    private Double fare;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;


}
