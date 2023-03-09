package com.example.bankingapp.domain.usecase;

import com.example.bankingapp.domain.gateway.TransferGateway;
import com.example.bankingapp.domain.model.Transfer;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TransferUseCase {

    private final TransferGateway transferGateway;

    public Transfer saveTransfer(Transfer transfer){
        return transferGateway.saveTransfer(transfer);
    }
}
