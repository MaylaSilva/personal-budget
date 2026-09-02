package br.com.personalbudget.model.entity;
import java.math.BigDecimal;
import java.sql.Date;

import br.com.personalbudget.model.base.Base;
import br.com.personalbudget.model.enums.CreditDebit;
import br.com.personalbudget.model.enums.TypeTransaction;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transactions")
@Getter
@Setter
public class Transaction extends Base{
    @Column (name = "date", nullable = false)
    private Date date;

    @Column (name = "amount", nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

    @Column (name = "description")
    private String description;

    @Column (name = "observation")
    private String observation;

    @ManyToOne
    @JoinColumn (name="categorybudget_id")
    private CategoryBudget category;

    @ManyToOne
    @JoinColumn (name="vendor_id")
    private Vendor vendor;

    @ManyToOne
    @JoinColumn (name="user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name="creditDebit", nullable = false)
    private CreditDebit creditDebit;

    @Enumerated(EnumType.STRING)
    @Column(name="type", nullable = false)
    private TypeTransaction typeTransaction;
}
