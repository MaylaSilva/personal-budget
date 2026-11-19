package br.com.personalbudget.service;

import org.springframework.stereotype.Service;

import br.com.personalbudget.dto.request.TransactionConfirmRequest;
import br.com.personalbudget.dto.request.TransactionCreateRequest;
import br.com.personalbudget.model.entity.Account;
import br.com.personalbudget.model.entity.Category;
import br.com.personalbudget.model.entity.Transaction;
import br.com.personalbudget.model.entity.Vendor;
import br.com.personalbudget.model.enums.TransactionOrigin;
import br.com.personalbudget.model.enums.TransactionStatus;
import br.com.personalbudget.model.enums.TransactionType;
import br.com.personalbudget.repository.AccountRepository;
import br.com.personalbudget.repository.CategoryRepository;
import br.com.personalbudget.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;

import java.time.YearMonth;
import java.util.UUID;


import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor 
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;
    private final VendorService vendorService;
    private final AccountRepository accountRepository;


    @Transactional(readOnly = true)
    public Transaction findTransactionByIdAndUser(UUID transactionId, UUID userId) {
        return transactionRepository.findByIdAndUserId(transactionId, userId)
            .orElseThrow(() -> new RuntimeException(
                "Transação não encontrada."
            ));
    }
     
    private Transaction create (TransactionCreateRequest request, UUID userId, TransactionOrigin origin, TransactionStatus status){
        Account account = accountRepository.findByIdAndUserId(request.getAccountId(), userId).orElseThrow (() -> new RuntimeException("Conta não encontrada"));
        Category category = categoryRepository.findByIdAndUserId(request.getCategoryId(), userId).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        YearMonth competence = (request.getTransactionType() == TransactionType.CREDITCARD)? request.getCompetence():null;
        if (request.getTransactionType() == TransactionType.CREDITCARD && competence==null){
            throw new IllegalArgumentException("A competência é obrigatória para compras no cartão de crédito.");
        }
        Vendor vendor = vendorService.findOrCreate(request.getVendorName(), userId);

        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setUser(account.getUser());
        transaction.setCategory(category);
        transaction.setVendor(vendor);
        transaction.setPurchaseDate(request.getPurchaseDate());
        transaction.setAmount(request.getAmount());
        transaction.setCreditDebit(request.getCreditDebit());
        transaction.setTransactionType(request.getTransactionType());
        transaction.setCompetence(competence);
        transaction.setTransactionOrigin(origin);
        transaction.setTransactionStatus(status);

        return transactionRepository.save(transaction);

    }
    @Transactional
    public Transaction createStatement (TransactionCreateRequest request, UUID userId){
        return create(request, userId, TransactionOrigin.IMPORTED, TransactionStatus.PENDING);
    }

    @Transactional
    public Transaction createManual (TransactionCreateRequest request, UUID userId){
        
        return create(request, userId, TransactionOrigin.MANUAL, TransactionStatus.APPROVED);
    }

    @Transactional 
    public Transaction confirm (TransactionConfirmRequest request, UUID userId, UUID transactionId){
        Transaction transaction = findTransactionByIdAndUser(transactionId, userId);

        if (transaction.getTransactionStatus() != TransactionStatus.PENDING){
            throw new IllegalStateException("Apenas transações pendentes podem ser confirmadas");
        }
    
            transaction.setDescription(request.getDescription());
            transaction.setObservation(request.getObservation());
            transaction.setTransactionStatus(request.isConfirm() ? TransactionStatus.APPROVED : TransactionStatus.CANCELED);

            return transactionRepository.save(transaction);


    }
    
}
