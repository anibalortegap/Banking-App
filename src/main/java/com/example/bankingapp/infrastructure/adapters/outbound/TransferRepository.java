package com.example.bankingapp.infrastructure.adapters.outbound;

import com.example.bankingapp.infrastructure.adapters.outbound.entities.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends JpaRepository<TransferEntity, Long> {
}
