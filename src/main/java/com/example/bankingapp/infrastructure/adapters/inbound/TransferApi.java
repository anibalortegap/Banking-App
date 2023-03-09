package com.example.bankingapp.infrastructure.adapters.inbound;

import com.example.bankingapp.domain.model.TransferResponse;
import com.example.bankingapp.domain.model.Transfer;
import com.example.bankingapp.domain.usecase.TransferUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/account", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class TransferApi {
    private final TransferUseCase transferUseCase;

    @PostMapping(path = "/transfer")
    public ResponseEntity<TransferResponse> saveTransfer(@RequestBody Transfer transfer){
        Transfer response = transferUseCase.saveTransfer(transfer);
        TransferResponse transferResponse = TransferResponse.builder()
                .transactionRef(response.getTransactionRef()).build();
        return new ResponseEntity<>(transferResponse, HttpStatus.OK);
    }

}
