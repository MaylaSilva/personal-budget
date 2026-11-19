package br.com.personalbudget.service;

import org.springframework.stereotype.Service;

import br.com.personalbudget.dto.request.TransactionConfirmRequest;
import br.com.personalbudget.dto.request.TransactionCreateRequest;
import br.com.personalbudget.model.entity.Account;
import br.com.personalbudget.model.entity.Category;
import br.com.personalbudget.model.entity.Transaction;
import br.com.personalbudget.model.entity.Vendor;
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
    public Transaction findTransactionById(UUID id) {
        return transactionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException(
                "Transação não encontrada."
            ));
    }
    @Transactional 
    public Transaction create (TransactionCreateRequest request, UUID userId){
        Account account = accountRepository.findByIdAndUserId(request.getAccountId(), userId).orElseThrow (() -> new RuntimeException("Conta não encontrada"));
        Category category = categoryRepository.findByIdAndUserId(request.getCategoryId(), userId).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        Vendor vendor = vendorService.findOrCreate(request.getVendorName(), userId);
        YearMonth competence = (request.getTransactionType() == TransactionType.CREDITCARD)? request.getCompetence():null;
        if (request.getTransactionType() == TransactionType.CREDITCARD && request.getCompetence()==null){
            throw new IllegalArgumentException("A competência é obrigatória para compras no cartão de crédito.");
        }

        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setUser(account.getUser());
        transaction.setCategory(category);
        transaction.setVendor(vendor);
        transaction.setPurchaseDate(request.getPurchaseDate());
        transaction.setAmount(request.getAmount());
        transaction.setCreditDebit(request.getCreditDebit());
        transaction.setTransactionType(request.getTransactionType());

        transaction.setCompetence(request.getCompetence());
        transaction.setTransactionStatus(TransactionStatus.PENDING);s

        return transactionRepository.save(transaction);

    }

    @Transactional 
    public Transaction confirm (TransactionConfirmRequest request, UUID userId, UUID transactionId){
        Transaction transaction = transactionRepository.findByIdAndUserId(transactionId, userId).orElseThrow(() -> new RuntimeException("Transação não encontrada"));

        if (transaction.getTransactionStatus() != TransactionStatus.PENDING){
            throw new IllegalStateException("Apenas transações pendentes podem ser confirmadas");
        }
    
        if (request.isConfirm()) {
            transaction.setDescription(request.getDescription());
            transaction.setObservation(request.getObservation());
            transaction.setTransactionStatus(TransactionStatus.APPROVED);

            return transactionRepository.save(transaction);
            
        } else {
            transaction.setDescription(request.getDescription());
            transaction.setObservation(request.getObservation());
            transaction.setTransactionStatus(TransactionStatus.CANCELED);

            return transactionRepository.save(transaction);

        }


    }
    
}
