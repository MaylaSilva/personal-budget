package br.com.personalbudget.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.UUID;

import br.com.personalbudget.model.enums.CreditDebit;
import br.com.personalbudget.model.enums.TransactionStatus;
import br.com.personalbudget.model.enums.TransactionType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class TransactionCreateRequest {
    @NotNull 
    private UUID categoryId;

    @NotNull 
    private UUID vendorId;

    @NotNull 
    private UUID accountId;
    
    @NotNull 
    private CreditDebit creditDebit;
    @NotNull 
    private TransactionType transactionType;

    @NotNull 
    private LocalDate purchaseDate;
    private YearMonth competence;

    @NotNull 
    private BigDecimal amount;
    
    private String description;
    private String observation;
    @NotNull 
    private TransactionStatus transactionstatus;

}
