package br.com.personalbudget.service;

import org.springframework.stereotype.Service;

import br.com.personalbudget.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;

}
