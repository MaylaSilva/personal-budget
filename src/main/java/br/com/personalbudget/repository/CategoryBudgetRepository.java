package br.com.personalbudget.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.personalbudget.model.entity.CategoryBudget;

@Repository
public interface CategoryBudgetRepository extends JpaRepository<CategoryBudget, Long>{

}
