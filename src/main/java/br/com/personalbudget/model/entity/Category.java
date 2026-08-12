package br.com.personalbudget.model;

import java.util.List;

import br.com.personalbudget.model.base.BasicRegistration;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="category")
public class Category extends BasicRegistration{
    @OneToMany(mappedBy="category")
    private List<Transaction> transactions;

    @OneToMany(mappedBy="category")
    private List<Budget> budgets;

    @OneToMany(mappedBy="category")
    private List<Vendor> vendors;
}
