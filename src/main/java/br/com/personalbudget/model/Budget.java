package br.com.personalbudget.model;
import java.math.BigDecimal;
import java.time.YearMonth;

import br.com.personalbudget.model.base.Base;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="budgets")
@Getter
@Setter
public class Budget extends Base{
    @Column(name = "limitAmount", nullable=false)
    private BigDecimal limitAmount;

    @Column(name = "monthReference", nullable=false)
    private YearMonth monthReference;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

}
