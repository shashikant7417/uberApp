package com.shashikant.project.uber.uberApp.services;

import com.shashikant.project.uber.uberApp.entities.Ride;
import com.shashikant.project.uber.uberApp.entities.User;
import com.shashikant.project.uber.uberApp.entities.Wallet;
import com.shashikant.project.uber.uberApp.entities.enums.TransactionMethod;

public interface WalletService {

    Wallet addMoneyToWallet(User user , Double amount , String transactionId, Ride ride, TransactionMethod transactionMethod);

    Wallet deductMoneyFromWallet(User user , Double amount , String transactionId, Ride ride, TransactionMethod transactionMethod);

    void withdrawAllMyMoneyFromWallet();

    Wallet findWalletById(Long walletId);

    Wallet createNewWallet(User user);

    Wallet findByUser(User user);
}
