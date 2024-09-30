package com.shashikant.project.uber.uberApp.strategies.impl;

import com.shashikant.project.uber.uberApp.entities.Driver;
import com.shashikant.project.uber.uberApp.entities.Payment;
import com.shashikant.project.uber.uberApp.entities.Rider;
import com.shashikant.project.uber.uberApp.entities.enums.PaymentStatus;
import com.shashikant.project.uber.uberApp.entities.enums.TransactionMethod;
import com.shashikant.project.uber.uberApp.repositories.PaymentRepository;
import com.shashikant.project.uber.uberApp.services.PaymentService;
import com.shashikant.project.uber.uberApp.services.WalletService;
import com.shashikant.project.uber.uberApp.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


// Rider had 232, Driver had 500
//Ride cost is 100, Commission = 30
//Rider = 232 -100 = 132
//Driver = 500 + (100 - 30) = 570



@Service
@RequiredArgsConstructor
@Transactional
public class WalletPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;

    @Override
    public void processPayment(Payment payment) {

        Driver driver = payment.getRide().getDriver();
        Rider rider = payment.getRide().getRider();

        walletService.deductMoneyFromWallet(rider.getUser(),
                payment.getAmount(), null, payment.getRide(), TransactionMethod.RIDE);
        double driverCut = payment.getAmount() * (1 - PLATFORM_COMMISSION);

        walletService.addMoneyToWallet(driver.getUser(), driverCut,null,payment.getRide(),TransactionMethod.RIDE);
        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);

    }
}
