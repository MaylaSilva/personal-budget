package br.com.personalbudget.service;

import org.springframework.stereotype.Service;

import br.com.personalbudget.repository.CategoryBudgetRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryBudgetService {
    private final CategoryBudgetRepository categoryBudgetRepository;
}
