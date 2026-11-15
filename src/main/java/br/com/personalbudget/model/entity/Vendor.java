package br.com.personalbudget.model.entity;

//import java.util.List;

import br.com.personalbudget.model.base.BasicRegistration;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "vendors")
@Getter
@Setter
public class Vendor extends BasicRegistration{
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
