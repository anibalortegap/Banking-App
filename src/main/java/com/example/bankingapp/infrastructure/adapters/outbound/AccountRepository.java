package com.example.bankingapp.infrastructure.adapters.outbound;

import com.example.bankingapp.infrastructure.adapters.outbound.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    @Query(value = "SELECT * FROM Account WHERE account_number =:accountNumber", nativeQuery = true)
    Optional<AccountEntity> findByAccountNumber(@Param("accountNumber") String accountNumber);
}
