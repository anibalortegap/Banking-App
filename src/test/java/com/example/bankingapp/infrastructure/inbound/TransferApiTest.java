package com.example.bankingapp.infrastructure.inbound;

import com.example.bankingapp.domain.model.Transfer;
import com.example.bankingapp.domain.model.TransferResponse;
import com.example.bankingapp.domain.usecase.TransferUseCase;
import com.example.bankingapp.infrastructure.adapters.inbound.TransferApi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

@WebMvcTest(controllers = {TransferApi.class})
public class TransferApiTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransferUseCase transferUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createTransfer() throws Exception {
        Transfer transfer = Transfer.builder()
                .id(1L)
                .senderAccount("024779")
                .recipientAccount("412789")
                .amount(new BigDecimal(10)).build();

        TransferResponse transferResponse = TransferResponse.builder()
                .transactionRef("f692a796-5d09-4188-9426-6c3e5d24a831").build();

        Mockito.when(transferUseCase.saveTransfer(transfer)).thenReturn(transfer);

    }

}
