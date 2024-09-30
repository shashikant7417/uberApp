package com.shashikant.project.uber.uberApp.services;

import com.shashikant.project.uber.uberApp.dtos.WalletTransactionDto;
import com.shashikant.project.uber.uberApp.entities.WalletTransaction;

public interface WalletTransactionService {

    void createNewWalletTransaction(WalletTransaction walletTransaction);
}
