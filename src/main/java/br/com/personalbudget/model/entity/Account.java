package br.com.personalbudget.model.entity;

import java.math.BigDecimal;

import br.com.personalbudget.model.base.BasicRegistration;
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
@Table(name = "accounts")
@Getter 
@Setter 
public class Account extends BasicRegistration {

    @Enumerated(EnumType.STRING)
    @Column(name="type", nullable = false)
    private TypeTransaction typeTransaction;

    @ManyToOne
    @JoinColumn (name="user_id")
    private User user;

    @Column(name="accountName",nullable=false)
    private String accountName;

    @Column(name="balance",nullable=false)
    private BigDecimal balance;

    @Column (name="closingDate")
    private Integer closingDate;

    @Column (name="dueDate")
    private Integer dueDate;

}
