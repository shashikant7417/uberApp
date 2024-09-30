package com.shashikant.project.uber.uberApp.services.impl;

import com.shashikant.project.uber.uberApp.entities.Payment;
import com.shashikant.project.uber.uberApp.entities.Ride;
import com.shashikant.project.uber.uberApp.entities.enums.PaymentStatus;
import com.shashikant.project.uber.uberApp.repositories.PaymentRepository;
import com.shashikant.project.uber.uberApp.services.PaymentService;
import com.shashikant.project.uber.uberApp.strategies.PaymentStrategyManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentStrategyManager paymentStrategyManager;

    @Override
    public void processPayment(Ride ride) {
        Payment payment = paymentRepository.findByRide(ride)
                        .orElseThrow(() -> new RuntimeException("Payment not found for ride:" + ride.getId()));

        paymentStrategyManager.paymentStrategy(ride.getPaymentMethod()).processPayment(payment);


    }

    @Override
    public Payment createNewPayment(Ride ride) {

        Payment payment = Payment.builder()
                .ride(ride)
                .paymentMethod(ride.getPaymentMethod())
                .amount(ride.getFare())
                .paymentStatus(PaymentStatus.PENDING)
                .build();
        return paymentRepository.save(payment);

    }

    @Override
    public void updatePaymentStatus(Payment payment, PaymentStatus paymentStatus) {

        payment.setPaymentStatus(paymentStatus);
        paymentRepository.save(payment);
    }
}
