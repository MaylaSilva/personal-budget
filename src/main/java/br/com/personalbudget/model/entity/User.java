package br.com.personalbudget.model.entity;
import java.util.List;

import br.com.personalbudget.model.base.Base;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends Base{

    @Column(name="name")
    private String name;

    @Column(name = "emailAddress",unique=true, nullable=false)
    private String emailAddress;

    @OneToMany(mappedBy="user")
    private List<Transaction> transactions;

    @OneToMany(mappedBy="user")
    private List<MonthlyBudget> monthlyBudgets;
}
