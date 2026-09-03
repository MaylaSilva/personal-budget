package br.com.personalbudget.service;

import org.springframework.stereotype.Service;
import br.com.personalbudget.repository.MonthlyBudgetRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MonthlyBudgetService {
    private final MonthlyBudgetRepository monthlyBudgetRepository;
}
