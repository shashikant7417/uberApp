package com.shashikant.project.uber.uberApp.services.impl;

import com.shashikant.project.uber.uberApp.dtos.WalletTransactionDto;
import com.shashikant.project.uber.uberApp.entities.WalletTransaction;
import com.shashikant.project.uber.uberApp.repositories.WalletTransactionRepository;
import com.shashikant.project.uber.uberApp.services.WalletTransactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WalletTransactionServiceImpl implements WalletTransactionService {

    private final ModelMapper modelMapper;
    private final WalletTransactionRepository walletTransactionRepository;

    @Override
    public void createNewWalletTransaction(WalletTransaction walletTransaction) {

        walletTransactionRepository.save(walletTransaction);

    }
}
