package br.com.personalbudget.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.UUID;

import br.com.personalbudget.model.enums.CreditDebit;
import br.com.personalbudget.model.enums.TransactionOrigin;
import br.com.personalbudget.model.enums.TransactionType;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class TransactionCreateRequest {
    @NotNull 
    private UUID categoryId;

    @NotBlank
    private String vendorName;

    @NotNull 
    private UUID accountId;
    
    @NotNull 
    private CreditDebit creditDebit;
    @NotNull 
    private TransactionType transactionType;

    @NotNull 
    private LocalDate purchaseDate;

    @AssertTrue (message = "A competência é obrigatória para compras no cartão de crédito.")
    public boolean isCompetenceValid(){
        if (this.transactionType == TransactionType.CREDITCARD){
            return this.competence!=null;
        }
        return true;
    }
    private YearMonth competence;

    @NotNull 
    private BigDecimal amount;
    
    @NotNull
    private TransactionOrigin transactionOrigin;
}
