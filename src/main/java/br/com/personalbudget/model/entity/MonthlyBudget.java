package br.com.personalbudget.model.entity;
import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;

import br.com.personalbudget.model.base.Base;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="monthlyBudgets")
@Getter
@Setter
public class MonthlyBudget extends Base{
    @Column (name = "monthReference", nullable=false)
    private YearMonth monthReference;

    @Column (name = "totalLimit", nullable = false, precision = 15, scale = 2)
    private BigDecimal totalLimit;

    @ManyToOne
    @JoinColumn (name="user_id", nullable=false)
    private User user;

    @OneToMany(mappedBy = "monthlyBudget")
    private List<CategoryBudget> categoryBudgets;
}
