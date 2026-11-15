package br.com.personalbudget.service;

import br.com.personalbudget.model.entity.Category;

import org.springframework.stereotype.Service;

import br.com.personalbudget.model.entity.Transaction;
import br.com.personalbudget.repository.AccountRepository;
import br.com.personalbudget.repository.CategoryRepository;
import br.com.personalbudget.repository.TransactionRepository;
import br.com.personalbudget.repository.UserRepository;
import br.com.personalbudget.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor 
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final VendorRepository vendorRepository;
    private final AccountRepository accountRepository;

    @Transactional(readOnly = true)
    public Transaction findTransactionById(UUID id) {
        return transactionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException(
                "Transação não encontrada."
            ));
    }
    @Transactional(readOnly = true)
    public Category findCategoryById(UUID id) {
        return categoryRepository.findById(id)
            .orElseThrow(() -> new RuntimeException(
                "Categoria não encontrada."
            ));
}
    
}
