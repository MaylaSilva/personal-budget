package br.com.personalbudget.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.personalbudget.model.entity.MonthlyBudget;

@Repository
public interface MonthlyBudgetRepository  extends JpaRepository<MonthlyBudget, UUID>{

}
