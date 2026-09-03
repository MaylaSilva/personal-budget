package br.com.personalbudget.service;

import org.springframework.stereotype.Service;
import br.com.personalbudget.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

}
