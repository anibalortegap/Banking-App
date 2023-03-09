package com.example.bankingapp.infrastructure.adapters.outbound;

import com.example.bankingapp.domain.gateway.TransferGateway;
import com.example.bankingapp.domain.model.Transfer;
import com.example.bankingapp.infrastructure.adapters.outbound.entities.AccountEntity;
import com.example.bankingapp.infrastructure.adapters.outbound.entities.TransferEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class TransferRepositoryAdapter implements TransferGateway {

    private static final Logger log = Logger.getLogger(TransferRepositoryAdapter.class.getName());
    private final TransferRepository transferRepository;
    private final AccountRepository accountRepository;

    private final ModelMapper mapper;
    @Override
    @Transactional(rollbackOn = Exception.class)
    public Transfer saveTransfer(Transfer transfer) {
        try {

            AccountEntity accountSender = accountRepository.findByAccountNumber(transfer.getSenderAccount())
                    .map(account -> mapper.map(account, AccountEntity.class))
                    .orElseThrow(() -> new RuntimeException("Account not found"));
            AccountEntity accountRecipient = accountRepository.findByAccountNumber(transfer.getRecipientAccount())
                    .map(account -> mapper.map(account, AccountEntity.class))
                    .orElseThrow(() -> new RuntimeException("Account not found"));;
            accountSender.debit(transfer.getAmount());
            accountRecipient.credit(transfer.getAmount());

            TransferEntity transferEntity = TransferEntity.builder()
                    .id(transfer.getId())
                    .senderAccount(transfer.getSenderAccount())
                    .recipientAccount(transfer.getRecipientAccount())
                    .amount(transfer.getAmount())
                    .transactionRef(UUID.randomUUID().toString())
                    .build();
            return mapper.map(transferRepository.save(transferEntity), Transfer.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
