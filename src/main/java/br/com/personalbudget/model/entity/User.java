package br.com.personalbudget.model;

import br.com.personalbudget.model.base.BasicRegistration;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BasicRegistration {
    @Column(name = "emailAddress",unique=true, nullable=false)
    private String emailAddress;

    @OneToMany(mappedBy="user")
    private List<Transaction> transactions;

    @OneToMany(mappedBy="user")
    private List<Budget> budgets;
}
