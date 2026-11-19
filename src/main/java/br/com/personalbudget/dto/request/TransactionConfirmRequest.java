package br.com.personalbudget.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class TransactionConfirmRequest {
    private String description;
    private String observation;
    private boolean confirm;

}
