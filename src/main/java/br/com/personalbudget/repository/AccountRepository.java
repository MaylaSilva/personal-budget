package br.com.personalbudget.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.personalbudget.model.entity.Account;

@Repository 
public interface AccountRepository extends JpaRepository<Account, UUID> {

    Optional<Account> findByIdAndUserId(UUID accountId, UUID userId);
    
}
