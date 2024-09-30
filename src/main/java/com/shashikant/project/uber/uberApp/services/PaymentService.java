package com.shashikant.project.uber.uberApp.services;

import com.shashikant.project.uber.uberApp.entities.Payment;
import com.shashikant.project.uber.uberApp.entities.Ride;
import com.shashikant.project.uber.uberApp.entities.enums.PaymentStatus;

public interface PaymentService {

    void processPayment(Ride ride);

    Payment createNewPayment(Ride ride);

    void updatePaymentStatus(Payment payment, PaymentStatus paymentStatus);
}
