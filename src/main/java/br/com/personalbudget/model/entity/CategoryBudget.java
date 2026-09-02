package br.com.personalbudget.model.entity;

import java.math.BigDecimal;

import br.com.personalbudget.model.base.Base;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="categoryBudget", uniqueConstraints={@UniqueConstraint(name="ukCategoryBudget", columnNames={"monthlybudget_id","category_id"})}) //precisa deixar com restrição para que não haja duplicidade na combinação que será a FK composta para gerar o orçamento mensal
@Getter
@Setter
public class CategoryBudget extends Base{
    @ManyToOne
    @JoinColumn(name="monthlybudget_id")
    private MonthlyBudget monthlyBudget;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @Column(name = "limitAmount", nullable = false, precision = 15, scale = 2)
    private BigDecimal limitAmount;

    @Column (name = "warningPercentage", nullable = false)
    private Integer warningPercentage;
}
