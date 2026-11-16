package br.com.personalbudget.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.personalbudget.model.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository <Transaction, UUID>{
    List<Transaction> findByUserIdAndCategoryIdAndDateBetween(
        Long userId,
        Long categoryId,
        LocalDate start,
        LocalDate end
    );
    
    Optional<Transaction> findByIdAndUserId(UUID transactionId, UUID userId);
}
