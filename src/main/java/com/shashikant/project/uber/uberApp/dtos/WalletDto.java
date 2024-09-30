package com.shashikant.project.uber.uberApp.dtos;

import com.shashikant.project.uber.uberApp.entities.User;
import com.shashikant.project.uber.uberApp.entities.WalletTransaction;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class WalletDto {

    private Long id;

    private UserDto user;

    private Double balance;

    private List<WalletTransactionDto> transactions;
}
