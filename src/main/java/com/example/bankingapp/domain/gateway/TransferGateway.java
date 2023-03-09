package com.example.bankingapp.domain.gateway;

import com.example.bankingapp.domain.model.Transfer;

public interface TransferGateway {

    Transfer saveTransfer(Transfer transfer);
}
