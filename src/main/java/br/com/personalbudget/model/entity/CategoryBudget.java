package br.com.personalbudget.model.entity;

import java.math.BigDecimal;
import java.time.YearMonth;

import br.com.personalbudget.model.base.Base;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="categoryBudget")
public class CategoryBudget extends Base{
    @ManyToOne
    @JoinColumn(name="monthly_budget_id")
    private MonthlyBudget monthlyBudget;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @Column(name = "limitAmount", nullable=false)
    private BigDecimal limitAmount;

    @Column(name = "monthReference", nullable=false)
    private YearMonth monthReference;

}
