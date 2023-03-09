package com.example.bankingapp.domain.usecase.transfer;

import com.example.bankingapp.domain.gateway.TransferGateway;
import com.example.bankingapp.domain.model.Transfer;
import com.example.bankingapp.domain.model.TransferResponse;
import com.example.bankingapp.domain.usecase.TransferUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

class TransferUseCaseTest {

    private Transfer transfer;
    @InjectMocks
    private TransferUseCase transferUseCase;
    @Mock
    private TransferGateway gateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        transfer = Transfer.builder()
                .id(1L)
                .senderAccount("09876")
                .recipientAccount("12345")
                .amount(new BigDecimal(10000))
                .build();
    }

    @Test
    void saveTransferBetweenAccountOk(){
        Mockito.when(gateway.saveTransfer(transfer)).thenReturn(transfer);
        Transfer response = transferUseCase.saveTransfer(transfer);
        Assertions.assertEquals(transfer, response);
    }
}
