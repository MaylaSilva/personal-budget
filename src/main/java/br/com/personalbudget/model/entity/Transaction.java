package br.com.personalbudget.model.entity;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;

import br.com.personalbudget.model.base.Base;
import br.com.personalbudget.model.enums.CreditDebit;
import br.com.personalbudget.model.enums.TransactionStatus;
import br.com.personalbudget.model.enums.TransactionType;
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
    @ManyToOne
    @JoinColumn (name="category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn (name="vendor_id", nullable = false)
    private Vendor vendor;

    @ManyToOne
    @JoinColumn (name="user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn (name="account_id", nullable = false)
    private Account account;

    @Enumerated(EnumType.STRING)
    @Column(name="creditDebit", nullable = false)
    private CreditDebit creditDebit;

    @Enumerated (EnumType.STRING)
    @Column (name="type", nullable=false)
    private TransactionType transactionType;

    @Column (name = "purchaseDate", nullable = false)
    private LocalDate purchaseDate;
    
    @Column (name = "competence")
    private YearMonth competence;

    @Column (name = "amount", nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

    @Column (name = "description")
    private String description;

    @Column (name = "observation")
    private String observation;

    @Column (name="transactionStatus")
    private TransactionStatus transactionStatus;
    

}
