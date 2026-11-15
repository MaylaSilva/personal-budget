package br.com.personalbudget.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;

import br.com.personalbudget.model.enums.CreditDebit;
import br.com.personalbudget.model.enums.TransactionType;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter 
@Setter 
public class TransactionFilterRequest {
    private UUID categoryId;  
    private UUID vendorId;
    private UUID accountId;
    
    private CreditDebit creditDebit;
    private TransactionType transactionType;

    private LocalDate startDate;
    private LocalDate endDate;
    private YearMonth startCompetence;
    private YearMonth endCompetence;

    private BigDecimal startAmount;
    private BigDecimal endAmount;
    
    private String description;
    private String observation;
    
}
